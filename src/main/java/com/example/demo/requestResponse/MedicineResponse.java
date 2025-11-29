package com.example.demo.requestResponse;

public class MedicineResponse {
    private Long id;
    private String name;
    private String price;
    private boolean isDiscontinued;
    private String manufacturerName;
    private String type;
    private String packSizeLabel;
    private String shortComposition1;
    private String shortComposition2;

    // Default constructor
    public MedicineResponse() {}

    // Parameterized constructor
    public MedicineResponse(Long id, String name, String price, boolean isDiscontinued, String manufacturerName,
                    String type, String packSizeLabel, String shortComposition1, String shortComposition2) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isDiscontinued = isDiscontinued;
        this.manufacturerName = manufacturerName;
        this.type = type;
        this.packSizeLabel = packSizeLabel;
        this.shortComposition1 = shortComposition1;
        this.shortComposition2 = shortComposition2;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isDiscontinued() {
        return isDiscontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        isDiscontinued = discontinued;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPackSizeLabel() {
        return packSizeLabel;
    }

    public void setPackSizeLabel(String packSizeLabel) {
        this.packSizeLabel = packSizeLabel;
    }

    public String getShortComposition1() {
        return shortComposition1;
    }

    public void setShortComposition1(String shortComposition1) {
        this.shortComposition1 = shortComposition1;
    }

    public String getShortComposition2() {
        return shortComposition2;
    }

    public void setShortComposition2(String shortComposition2) {
        this.shortComposition2 = shortComposition2;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", isDiscontinued=" + isDiscontinued +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", type='" + type + '\'' +
                ", packSizeLabel='" + packSizeLabel + '\'' +
                ", shortComposition1='" + shortComposition1 + '\'' +
                ", shortComposition2='" + shortComposition2 + '\'' +
                '}';
    }
}
