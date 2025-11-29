package com.example.demo.service;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserMedicineMapping;
import com.example.demo.model.Users;
import com.example.demo.repository.MedicineMasterRepo;
import com.example.demo.repository.UserMedicineMappingRepository;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ImageService {
	
	private final Integer nameXCoordinate=260;
	private final Integer nameYCoordinate=750;
	
	private final Integer ageXCoordinate=1510;
	private final Integer ageYCoordinate=750;
	
	private final Integer dateXCoordinate=1900;
	private final Integer dateYCoordinate=750;
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMedicineMappingRepository userMedicineMappingRepository;
	
	@Autowired
	private MedicineMasterRepo medicineMasterRepo;
	

    private final int width = 500; // Width of the drawing area
    private final int height = 580; // Height of the drawing area


    public void addTextToImageAndSend(HttpServletResponse response, Long id) throws IOException {
    	
    	Users user = userRepository.findById(id).get();
    	List<UserMedicineMapping> allMedicines = userMedicineMappingRepository.findByUserIdAndIsActiveTrue(user.getId());
        Resource resource = new ClassPathResource("images/Rudra_Skin Care_2.1.png");
        BufferedImage image = ImageIO.read(resource.getInputStream());
        
        // Create a Graphics2D object
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("Arial", Font.BOLD, 48));
        g2d.setColor(Color.BLACK);
        g2d.setComposite(AlphaComposite.SrcOver.derive(0.8f)); // Semi-transparent text

        Integer x=nameXCoordinate;
        Integer y=nameYCoordinate;
        g2d.drawString(user.getPatientName(), x, y); // name
        g2d.drawString(user.getAge().toString(), ageXCoordinate, ageYCoordinate); // age
        g2d.drawString("Next Visit Date : ".concat(user.getFutureAppointment()), ageXCoordinate-800	,ageYCoordinate); // Next Visit Date
        
        Date date = user.getCreatedDate();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = formatter.format(date);
        g2d.drawString(formattedDate, dateXCoordinate, dateYCoordinate); // date
        g2d.drawString("Medicine", 800	,1100); // Medicine Title
        g2d.drawString("Dosage", 1800,1100); // Dosage Title
        g2d.drawString("Qty", 2200	,1100); // Dosage Title
        
        
        Graphics2D g2dItalic = image.createGraphics();
        g2dItalic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2dItalic.setFont(new Font("Arial", Font.ITALIC, 60));
        g2dItalic.setColor(Color.BLACK);
        g2dItalic.setComposite(AlphaComposite.SrcOver.derive(0.8f));
        
        g2dItalic.setFont(new Font("Arial", Font.BOLD, 50));
        g2dItalic.setFont(new Font("Arial", Font.ITALIC, 60));
        g2dItalic.drawString("Dr. Nidhi Loriya", 2000	,2800); // Dr Name
        g2dItalic.setFont(new Font("Arial", Font.ITALIC, 40));
        g2dItalic.drawString("BHMS,CSVD", 2180	,2870); // Dr Name
        g2dItalic.setFont(new Font("Arial", Font.ITALIC, 35));
        
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(726, 1160, 2347, 1160);
        
        Integer lineYCoordinate = 1330;
        for (int i=0,j = 100; i < allMedicines.size(); i++) {
        	g2d.drawLine(726, lineYCoordinate, 2347, lineYCoordinate);
        	g2d.drawString(String.valueOf(i+1 + ")"), 720	,1150+j); 		// Medicine Name
        	g2d.drawString(medicineMasterRepo.findById(allMedicines.get(i).getMedicineId()).get().getName(), 800	,1150+j); 		// Medicine Name
//        	g2dItalic.drawString("Composition  :".concat(medicineMasterRepo.findById(allMedicines.get(i).getMedicineId()).get().getName()), 800	,1210+j); 		// Medicine Name
        	g2d.drawString(allMedicines.get(i).getDuration(), 1820	,1150+j); 	// Duration
        	g2d.drawString(allMedicines.get(i).getQuentity().toString(), 2220	,1150+j); 	// Duration
        	j=j+150;
        	lineYCoordinate = lineYCoordinate + 155;
		}
        
//        g2dItalic.drawString("BHMS,CSVD", 2180	,2870); // Dr Name
        drawWrappedText(g2d, user.getDx(), 80, 1000, width, height); // dx
        drawWrappedText(g2d, user.getCo(), 80, 1850, width, height); // co
        g2dItalic.dispose();
        g2d.dispose();
        

        // Convert to byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        byte[] imageData = baos.toByteArray();
        
        // Set response headers
        response.setContentType("image/png");
        response.setHeader("Content-Disposition", "attachment; filename=\"image-with-text.png\"");
        response.setContentLength(imageData.length);
        
        // Write image data to output stream
        ServletOutputStream out = response.getOutputStream();
        out.write(imageData);
        out.flush();
        out.close();
    }
    
	private void drawWrappedText(Graphics2D g2d, String text, int x, int y, int width, int height) {
		FontMetrics fontMetrics = g2d.getFontMetrics();
		int lineHeight = fontMetrics.getHeight();
		int currentX = x;
		int currentY = y;
		String[] words = text.split(" ");
		StringBuilder line = new StringBuilder();
		for (String word : words) {
			String testLine = line.toString() + word + " ";
			Rectangle2D textBounds = fontMetrics.getStringBounds(testLine, g2d);
			if (textBounds.getWidth() > width) {
				g2d.drawString(line.toString().trim(), currentX, currentY);
				line.setLength(0); // Reset the StringBuilder
				line.append(word).append(" ");
				currentY += lineHeight;
				if (currentY > y + height) {
					break; // Stop drawing if the text exceeds the height of the area
				}
			} else {
				line.append(word).append(" ");
			}
		}
		if (line.length() > 0) {
			g2d.drawString(line.toString().trim(), currentX, currentY);
		}
	}
}
