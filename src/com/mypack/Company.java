package com.mypack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Company  implements Serializable {
	
	
	
	int companyid;
	
	String companyname;
	
	Customer cust;
	

	public int getCompanyid() {
		return companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	
	
	public Company(int companyid, String companyname,Customer cust) {
		this.cust=cust;
		this.companyid = companyid;
		this.companyname = companyname;
	}

	public static void main(String arr[]) throws Exception{
		
		Customer cust= new Customer(10,"sanjay b");
		
		Company com= new Company(1,"alle",cust);
		
		FileOutputStream fout= new FileOutputStream("d://serilze.txt");
		
		ObjectOutputStream out= new ObjectOutputStream(fout);
		
		
		out.writeObject(com);
		out.flush();
		out.close();
		
		
		
		
		
	}

}
