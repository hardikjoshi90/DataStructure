package com.pckg.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonPattern {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("Enter the number of test cases: ");
		int n = getInt();
		for (int i = 0; i < n; i++) {
			String A = getString();
			String B = getString();
			int ans = longestCommonPattern(A, B);
			System.out.println(ans);
		}

	}

	private static int longestCommonPattern(String a, String b) {
		// TODO Auto-generated method stub
		int count = 0;
		char[] str1 = new char[a.length()];
		char[] str2 = new char[b.length()];
		str1 = a.toCharArray();
		str2 = b.toCharArray();

		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if ((int) str1[i] == (int) str2[j]) {
					count++;
					str2[j] = '%';
					break;
				}
			}
		}

		return count;

	}

	private static int getInt() throws IOException {
		// TODO Auto-generated method stub
		String s = getString();
		return Integer.parseInt(s);
	}

	private static String getString() throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String s = br.readLine();
		return s;
	}

}
