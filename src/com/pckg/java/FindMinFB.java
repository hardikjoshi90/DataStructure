package com.pckg.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindMinFB {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String sCurrentLine;
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		while ((sCurrentLine = br.readLine()) != null) {
			String[] input = sCurrentLine.split(",");
			for(String str:input)
			System.out.println(str);
			
		}

	}

}
