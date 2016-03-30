package com.mypack;

public class StaticVolatileThreading implements Runnable{


   public static volatile int  counter=6;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StaticVolatileThreading ob= new StaticVolatileThreading();
		
		StaticVolatileThreading ob1= new StaticVolatileThreading();
		
		
		Thread w1= new Thread(ob);
		w1.setName("writer");
		Thread r1= new Thread(ob);
		r1.setName("reader1");
		Thread r2= new Thread(ob);
		r2.setName("reader2");
		
		Thread r3= new Thread(ob1);
		r3.setName("reader11");
		Thread r4= new Thread(ob1);
		r4.setName("reader21");
		
		
		
		Thread w2= new Thread(ob1);
		w2.setName("writer2");
		
		r1.start();
		
		w1.start();
		//r2.start();
	//	w2.start();
		
		//r3.start();
	//	r4.start();
	}

	@Override
	public void run() {
		
	for(int i=0;i<3;i++){
		System.out.println("Iteration no "+i);
		 if(Thread.currentThread().getName().equals("reader1")){
			counter++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" reads value is "+counter);
		}
		 else if(Thread.currentThread().getName().equals("writer")){
			
			counter++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("write1 complete "+counter);
		}
		
		else if(Thread.currentThread().getName().equals("reader2")){
			counter++;
			
			System.out.println(Thread.currentThread().getName()+" reads value is "+counter);
		}
		else if(Thread.currentThread().getName().equals("reader21")){
			counter++;
			
			System.out.println(Thread.currentThread().getName()+" reads value is "+counter);
		}
		else if(Thread.currentThread().getName().equals("reader11")){
			counter++;
			
			System.out.println(Thread.currentThread().getName()+" reads value is "+counter);
		}
		 
		else if(Thread.currentThread().getName().equals("writer2")){
			
			counter++;
			System.out.println("write2 complete");
			
		}
	}
		
	}
	
	
	
	
	

}
