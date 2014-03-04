package com.pckg.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Armstrong {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String sCurrentLine;
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		while ((sCurrentLine = br.readLine()) != null) {
			int number = Integer.parseInt(sCurrentLine);
			int digits = getDigits(number);
			int sum = 0;

			while (number > 0) {
				sum = (int) (sum + Math.pow(number % 10, digits));
				number = number / 10;
			}

			if (sum == Integer.parseInt(sCurrentLine))
				System.out.println("True");
			else
				System.out.println("False");
		}

	}

	private static int getDigits(int num) {
		// TODO Auto-generated method stub
		int count = 0;
		while (num > 0) {
			count++;
			num = num / 10;
		}
		return count;
	}

}
