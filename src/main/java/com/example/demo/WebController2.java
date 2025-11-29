package com.example.demo;

public class WebController2 extends Thread {
	
	public static void main(String[] args) {
		System.out.println("Hello sweta");
		System.out.println(Thread.currentThread().getName());
		Thread t1 = new Thread();
		t1.start();
		System.out.println(Thread.currentThread().getName());
	}
	
}