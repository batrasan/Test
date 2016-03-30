package com.mypack;


// http://www.ibm.com/developerworks/java/library/j-jtp02183/index.html

// for mutable and immutable
public class Person implements Cloneable {

	public String name;
	public int roll;
	
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
		}  
	
	
	
	
	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public int getRoll() {
		return roll;
	}





	public void setRoll(int roll) {
		this.roll = roll;
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x=10;
		
		Person p1= new Person();
		p1.setName("vinit");
		p1.setRoll(10);
		System.out.println("name of student is "+p1.getName()+" and roll is "+p1.getRoll()+"and value of x "+x);
		p1.myC(p1,x);
		
		System.out.println("name of student is "+p1.getName()+" and roll is "+p1.getRoll()+"and value of x "+x);
		
	}
	
	public void myC(Person p,int  y){
		
		p.setName("sanjay");
		p.setRoll(20);
		y+=20;
		
		
		
		
	}
	
	
	
	
	
	

}
