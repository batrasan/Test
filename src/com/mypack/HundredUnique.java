package com.mypack;

import java.util.ArrayList;
import java.util.Iterator;

public class HundredUnique implements Runnable {

	static ArrayList<Integer> al= new ArrayList<Integer>();
	
	
	static int Lindex=0;
	static int Uindex=0;
	static int previousmid;
	static int 	mid;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int no[]={1,1,1,1,3,4,5,6,7,7,7,9,9,11,12,13,14,15,15,15,15,16,16,16,17,17,18,18,22,23,24,25,26,27,33,33,45,55,55,55,55,55,56,66,66,66,77,88,98,99};		
		HundredUnique ob= new HundredUnique();
		Thread t1= new Thread(ob);
		t1.start();
		Lindex=0;
		Uindex=no.length-1;
		//mid=(Lindex+Uindex)/2;
		mid=Uindex-5;
		try{
		ob.Bsearch(no,Lindex,Uindex,mid);		
		}finally{
		
		Iterator itr= al.iterator();
		while(itr.hasNext()){
			System.out.println("inside main");
			System.out.println(itr.next());
		}
		}
		
	}
	
	public void Bsearch(int input[],int lindex,int uindex,int mid){
		
		
		System.out.println("inside Bserach");
		System.out.println(input[mid]);
		al.add(input[mid]);
		 Uindex=mid;
		 previousmid=mid;
		// mid=(Lindex+Uindex)/2;
		 mid=Uindex-5;
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(input[previousmid]!=input[mid])
		Bsearch(input,Lindex,Uindex,mid);
		 else{
			 Uindex=mid;
			 mid=mid-5;
			 
			 Bsearch(input,Lindex,Uindex,mid);
		 }
	}
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			
		System.out.println("reached here");
			System.out.println("list size"+al.size());
			if(al.size()==5){
			
			Iterator itr= al.iterator();
			while(itr.hasNext()){
				System.out.println(itr.next());
			}
			break;
		}	
		
		
		}
	}
	}
