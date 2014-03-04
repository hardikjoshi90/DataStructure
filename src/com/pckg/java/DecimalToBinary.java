package com.pckg.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DecimalToBinary {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String sCurrentLine;
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		while ((sCurrentLine = br.readLine()) != null) {
			if (sCurrentLine.trim().length() == 0) {
				continue; // Skip blank lines
			} else {
				int n=Integer.parseInt(sCurrentLine);
				String bin="";
				while(n>0){
					bin= bin+ n%2;
					n=n/2;
				}
				System.out.print(new StringBuilder(bin).reverse().toString());				
			}
			System.out.println();
		}
	}
}
