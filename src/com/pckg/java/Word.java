package com.pckg.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Word {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String sCurrentLine;
		int count=0;
		BufferedReader br = new BufferedReader(new FileReader("E:\\Hemlet.txt"));
		while((sCurrentLine = br.readLine())!=null){
			if(sCurrentLine.contains("king"))
				count = count+1;
		}
		
		System.out.println("King counts:"+count);

	}

}
