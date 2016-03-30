package com.mypack;

public class ShallowCloning implements Cloneable {

	int x;
	Person p;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}	
	
	
	@Override
	protected ShallowCloning clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		 ShallowCloning ob= new ShallowCloning();
		/* Person p1= new Person();
		 p1.setName(this.p.getName());
		 p1.setRoll(this.p.getRoll());*/
		// ob.setP((Person)p.clone());
		 ob.setP(this.p);
		 ob.setX(this.x);
		 return ob;
	}
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Person p1= new Person();
		p1.setName("sanjay");
		p1.setRoll(10);
		ShallowCloning original= new ShallowCloning();
		original.setP(p1);
		original.setX(20);
		
		ShallowCloning cloneOb= (ShallowCloning) original.clone();
		
		
		System.out.println(cloneOb.getX());
		System.out.println(cloneOb.getP().getName()+"  "+cloneOb.getP().getRoll());
		
		p1.setName("vinit");
		original.setX(44);
		original.setP(p1);
		
		System.out.println(cloneOb.getX());
		System.out.println(cloneOb.getP().getName()+"  "+cloneOb.getP().getRoll());
		
	}

}
