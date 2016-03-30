/**
 * 
 */
package com.mypack;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

/**
 * @author vrane
 *
 */
public class Customer implements Externalizable {
	
	 int custid;
	public Customer() {
		super();
	}
	 String custname;
	public Customer(int custid2, String customername) {
		this.custid=custid2;
		
		this.custname=customername;
		// TODO Auto-generated constructor stub
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(getCustname());
		//out.writeInt(getCustid());
		
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
	
		custname= (String) in.readObject();
		//custid=in.readInt();
		
	}
	
	

}
