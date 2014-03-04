package com.pckg.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class oddNumbers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		/*for(int i=1;i<99;i++){
			boolean flag = isOdd(i);
			if(flag)
				System.out.println(i);
		}*/
		String sCurrentLine;
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		while ((sCurrentLine = br.readLine()) != null) {
			int number = Integer.parseInt(sCurrentLine);
			boolean flag = isEven(number);
			if(flag)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}

	private static boolean isEven(int number) {
		// TODO Auto-generated method stub
		return (number%2==0);
	}

	/*private static boolean isOdd(int i) {
		// TODO Auto-generated method stub
		return (i%2!=0);
	}*/

}
