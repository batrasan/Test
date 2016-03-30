package com.mypack;

import java.util.Scanner;

public class ArrayDiagonal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input= new Scanner(System.in);
		System.out.println("Please enter the size of array");
		int n=input.nextInt();
		int arr[][] = new int[n][n];
		
		int onDiagonal=0;
		int offDiagonal=0;
		
		
		for(int r=0;r<n;r++){
			for(int c=0;c<n;c++){
		
				arr[r][c]=input.nextInt();
		
				if(r==c){
					onDiagonal+=arr[r][c];
				}
				
				if((r+c)==(n-1)){
					offDiagonal+=arr[r][c];
					
				}
				
			}
			
		}
		
		System.out.println("diagonal are on and off resp "+onDiagonal +" "+offDiagonal);
		
		System.out.println("Absolute diff between diagonal is "+Math.abs(onDiagonal-offDiagonal));
		
		
		
		
		
		
		
		
	}

}
