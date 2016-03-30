package com.mypack;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Optional;

import javax.xml.bind.annotation.XmlAccessOrder;

public class FileHandling implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3410916017804030421L;
	private int roll;
	private String name;
	private String fname;
	//private String aa;
	
	
	

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			
			/*FileOutputStream fin= new FileOutputStream(new File("d://xyz.txt"));
			
			ObjectOutputStream ou= new ObjectOutputStream(fin);
			
		FileHandling fh= new FileHandling();
		fh.setName("sanjay");
		fh.setRoll(1);
		XMLEncoder myencoder= new XMLEncoder(ou);
		myencoder.writeObject(fh);
			myencoder.close();
		ou.writeObject(fh);
			ou.flush();
		
			ou.close();*/
			
			
			FileInputStream fout= new FileInputStream("d://abc.xml");
			
			ObjectInputStream is= new ObjectInputStream(fout);
			
			FileHandling fhin= (FileHandling) is.readObject();
			
			System.out.println(fhin.name);
			System.out.println(fhin.roll);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		return "FileHandling [roll=" + roll + ", name=" + name + "]";
	}

}
