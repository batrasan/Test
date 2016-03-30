package com.mypack;

import javax.management.ImmutableDescriptor;

public class Checker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person();
		int x = 10;
		p.setName("vinit");
		p.setRoll(10);

		Checker c = new Checker();
		System.out.println("name of student is " + p.getName() + " and roll is " + p.getRoll() + "and value of x " + x);
		c.myC(p, x);

		System.out.println("name of student is " + p.getName() + " and roll is " + p.getRoll() + "and value of x " + x);

		// immutability check
		int arr[] = { 1, 2, 3, 4, 5 };

		Immytablity imm = new Immytablity(arr);

		int arr1[] = imm.getArray();

		arr1[3] = 20;

		int arr2[] = imm.getArray();
		for (int i = 0; i < arr2.length; i++) {
			System.out.println("Value after change are " + arr2[i]);

		}

	}

	public void myC(Person p, int y) {

		p.setName("sanjay");
		p.setRoll(20);
		y += 20;

	}

}
