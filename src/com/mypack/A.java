package com.mypack;

public class A {

	public A(Object a){
		System.out.println("inside object");
	}
	
	
	public A(String a){
		System.out.println("inside String");
	}
	
	
	public static void main(String[] args) {
		
		
		new A(null);

	}

}
