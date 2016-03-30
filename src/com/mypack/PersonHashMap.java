package com.mypack;

import java.util.HashMap;

public class PersonHashMap {
	public String name;
	public int roll;
	

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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + roll;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonHashMap other = (PersonHashMap) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (roll != other.roll)
			return false;
		return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<PersonHashMap, String> hm= new HashMap<PersonHashMap, String>();
		
		PersonHashMap p1= new PersonHashMap();
		
		p1.setName("vinit");
		p1.setRoll(10);
		
		System.out.println("hasg code"+p1.hashCode());
		
		PersonHashMap p2= new PersonHashMap();

		p2.setName("sanjay");
		p2.setRoll(20);
		System.out.println("hasg code"+p2.hashCode());
		
		hm.put(p1, "first");
		hm.put(p2, "second");
		
		
		System.out.println(hm.get(p1));
		
		
		p1.setName("vinit");
		p1.setRoll(20);
		
		System.out.println("hash code is "+p1.hashCode());
		System.out.println(hm.get(p1));
			
		
	}

}
