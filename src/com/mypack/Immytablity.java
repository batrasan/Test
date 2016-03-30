package com.mypack;

public class Immytablity {

	
	private final int[] theArray;
	
	public Immytablity(int[] anArray) {
	    this.theArray = anArray;
	  }
	
	public int[] getArray()       { return theArray.clone(); }
	
}
