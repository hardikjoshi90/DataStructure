package com.datastructure.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class triangleApp {
	static int theNumber;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter a Number:");
		theNumber = getInt();
		int answer = triangle(theNumber);
		System.out.println("Answer is:"+answer);
	}
	
	public static int triangle(int n){
		if(n==1)
			return 1;
		else
			return n + triangle(n-1);
			
	}
	
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String s = br.readLine();
		return s;
	}

}
