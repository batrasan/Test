package com.mypack;

import java.lang.management.ThreadInfo;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DeadlockConsoleHandler implements DeadlockHandler {

	  @Override
	  public void handleDeadlock(final ThreadInfo[] deadlockedThreads) {
		  System.out.println("reached here 2");
	    if (deadlockedThreads != null) {
	      System.err.println("Deadlock detected!");
	      
	      Map<Thread, StackTraceElement[]> stackTraceMap = Thread.getAllStackTraces();
	      for (ThreadInfo threadInfo : deadlockedThreads) {
	      
	        if (threadInfo != null) {
	      
	          for (Thread thread : Thread.getAllStackTraces().keySet()) {
	        
	            if (thread.getId() == threadInfo.getThreadId()) {
	              System.err.println(threadInfo.toString().trim());
	                
	              for (StackTraceElement ste : thread.getStackTrace()) {
	                  System.err.println("\t" + ste.toString().trim());
	              }
	            }
	          }
	        }
	      }
	    }
	  }
	  
	  public static void main(String arr[]){
		  DeadlockDetector deadlockDetector = new DeadlockDetector(new DeadlockConsoleHandler(), 5, TimeUnit.SECONDS);
		  deadlockDetector.start();

		  final Object lock1 = new Object();
		  final Object lock2 = new Object();

		  Thread thread1 = new Thread(new Runnable() {
		    @Override
		    public void run() {
		      synchronized (lock1) {
		        System.out.println("Thread1 acquired lock1");
		        try {
		          TimeUnit.MILLISECONDS.sleep(500);
		        } catch (InterruptedException ignore) {
		        }
		        synchronized (lock2) {
		          System.out.println("Thread1 acquired lock2");
		        }
		      }
		    }

		  });
		  thread1.start();

		  Thread thread2 = new Thread(new Runnable() {
		    @Override
		    public void run() {
		      synchronized (lock2) {
		        System.out.println("Thread2 acquired lock2");
		        synchronized (lock1) {
		          System.out.println("Thread2 acquired lock1");
		        }
		      }
		    }
		  });
		  thread2.start();
		  
	  }
	  
	  
	}
