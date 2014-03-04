package com.pckg.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class revWords {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String sCurrentLine;
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		while ((sCurrentLine = br.readLine()) != null) {
			if (sCurrentLine.trim().length() == 0) {
				continue; // Skip blank lines
			} else {
				String revStr = new StringBuilder(sCurrentLine).reverse()
						.toString();
				for (String part : revStr.split(" ")) {
					System.out.print(new StringBuilder(part).reverse()
							.toString() + " ");
				}
			}
			System.out.println();
		}
	}
}
