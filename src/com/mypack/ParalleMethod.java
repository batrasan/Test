package com.mypack;

public class ParalleMethod implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		if(Thread.currentThread().getName().equals("thread1"))
		{
			Method1();
			
		}
		else
		{
			
			//Method2();
		}
		
		
	}
	
	public void Method1(){
		for(int i=0;i<20;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("method1");
		}
		
	}
	
	public static void Method2(){
		for(int i=0;i<20;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("method2");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ParalleMethod ob= new ParalleMethod();
		Thread t1= new Thread(ob);
		t1.setName("thread1");
		
		Thread t2= new Thread(ob);
		t2.setName("thread2");
		
		t1.start();
		
		
		
		Method2();
		
		
		
		
	}

}
