package com.mypack;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Externalissation implements Externalizable {

	int x;
	 String y;
	 int z;
	
	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	Customer cust;
	
	
	
	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	
	public Externalissation() {
		super();
	}

	
	public Externalissation(int x, String y,Customer cust,int z) {
		super();
		this.z=z;
		this.cust=cust;
		this.x = x;
		this.y = y;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		
		out.writeObject(getY());
		out.writeInt(getX());
		out.writeInt(getZ());
		out.writeObject(getCust());
		
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		 this.y=(String) in.readObject();
		 this.x=in.readInt();
		 this.cust=(Customer) in.readObject();
			
		
	}
	
	public static void main(String arr[]) throws Exception{
		Customer cust= new Customer(1,"vinit");
		Externalissation ob= new Externalissation(10,"sanjay",cust,50);
		
		Externalissation newob=null;
		
		FileOutputStream fout= new FileOutputStream("d://extern.txt");
		
		ObjectOutputStream oout= new ObjectOutputStream(fout);
		
		
		oout.writeObject(ob);
		
		oout.flush();
		
		oout.close();
		
		
		/// object retriving
		
		
		FileInputStream fin= new FileInputStream("d://extern.txt");
		
		ObjectInputStream oin= new ObjectInputStream(fin);
		
		newob=(Externalissation) oin.readObject();
		
		System.out.println(newob.getX() +"   "+newob.getY()+" "+newob.getCust().getCustname());
		
		
		oin.close();
	}
	
	
	
	

}
