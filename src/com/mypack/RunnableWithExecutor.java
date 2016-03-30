package com.mypack;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableWithExecutor implements Runnable{

	public static void main(String[] args) throws Exception, ExecutionException {
		
		Thread t1= new Thread(new RunnableWithExecutor());
		System.out.println(t1.getState());
		t1.setUncaughtExceptionHandler( new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t1, Throwable e) {
				// TODO Auto-generated method stub
				
				System.out.println("Exceptin by "+t1.currentThread()+"Exceptio i s"+e+"state of Thread is "+t1.getState());
				
			}
		});
		t1.start();
		System.out.println(t1.getName()+""+t1.getState());
					
	}	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("inside run method"+Thread.currentThread().getName()+" "+Thread.currentThread().getState());
		try{
			
			String x=null;
			String a= new String(x);
			System.out.println("inside run method"+Thread.currentThread().getName()+" "+Thread.currentThread().getState());
		}
		
		catch(ArithmeticException ie){
			ie.printStackTrace();
		}
		System.out.println("after cagtch");	
		
	}

}
