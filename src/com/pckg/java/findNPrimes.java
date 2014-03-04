package com.pckg.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class findNPrimes {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String sCurrentLine;
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		List<String> prime = new ArrayList<String>();
		while ((sCurrentLine = br.readLine()) != null) {
			if (sCurrentLine.trim().length() == 0) {
				continue; // Skip blank lines
			} else {
				int count = 0;
				String p="";
				for (int i = 2; i < Integer.parseInt(sCurrentLine); i++) {
					for (int j = 1; j <= i; j++) {
						if (i % j == 0)
							count = count + 1;
					}
					if (count == 2)
						if(p.isEmpty())
							p=i+",";
						else
							p=p+i+",";
					count = 0;
				}
				p=p.substring(0,p.length()-1);
				prime.add(p);
			}	
		}
		for(String pr:prime)
		 System.out.println(pr);
	}
}
