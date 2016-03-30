package com.mypack;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class InnerClassConstrutor implements Externalizable {
	
	int outerx;
	myInner myin;
	
	public myInner getMyin() {
		return myin;
	}

	public void setMyin(myInner myin) {
		this.myin = myin;
	}


	public InnerClassConstrutor() {
		super();
	}

	public InnerClassConstrutor(int outerx,myInner myin) {
		super();
		this.outerx = outerx;
		this.myin=myin;
	}

	public int getOuterx() {
		return outerx;
	}

	public void setOuterx(int outerx) {
		this.outerx = outerx;
	}

	static class myInner implements Externalizable{
		
		int innerx;
		
		public int getInnerx() {
			return innerx;
		}

		public void setInnerx(int innerx) {
			this.innerx = innerx;
		}

		
		public myInner(int innerx) {
			super();
			this.innerx = innerx;
		}

		public myInner(){
			
		}

		@Override
		public void writeExternal(ObjectOutput out) throws IOException {
			out.writeInt(innerx);
			
		}

		@Override
		public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
			// TODO Auto-generated method stub
			
			this.innerx=in.readInt();
			
		}
		
	}	
	
	
	public static void main(String arr[]) throws Exception{		
		
		FileOutputStream fout= new FileOutputStream("d:\\inner.txt");
		
		ObjectOutputStream out= new ObjectOutputStream(fout);
		
		
	// it is proved that inner class cannot be used as externalizable	
	//InnerClassConstrutor inc=new InnerClassConstrutor(20, );
		
		
		
		
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(myin);
		out.writeInt(outerx);
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
	
		this.myin=(myInner) in.readObject();
		this.outerx=in.readInt();
		
	}
	
	
}
