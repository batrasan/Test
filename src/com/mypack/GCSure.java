package com.mypack;

public class GCSure {

	public static GCSure gcsure=null; 
	
	public int x;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime rt= Runtime.getRuntime();
		
		long l=rt.totalMemory();
		System.out.println(rt.freeMemory());
		GCSure ob= new GCSure();
		
		long l1=rt.totalMemory();	
	
		System.out.println(l1);
		System.out.println(l-l1);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub		
		gcsure=this;		
		super.finalize();
	}

}
