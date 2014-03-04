package com.datastructure.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnagramApp {
	static int size;
	static int count;
	static char arrCh[] = new char[100];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter Word: ");
		String s = getString();
		size = s.length();
		count = 0;

		for (int i = 0; i < size; i++)
			arrCh[i] = s.charAt(i);
		doAnagram(size);

	}

	private static void doAnagram(int newSize) {
		// TODO Auto-generated method stub
		if (newSize == 1)
			return;
		for (int j = 0; j < newSize; j++) {
			doAnagram(newSize - 1);
			if (newSize == 2)
				displayWord();
			rotate(newSize);
		}

	}

	private static void rotate(int newSize) {
		// TODO Auto-generated method stub
		int j;
		int position = size - newSize;
		char temp = arrCh[position];
		for (j = position + 1; j < size; j++)
			arrCh[j - 1] = arrCh[j];
		arrCh[j - 1] = temp;

	}

	private static void displayWord() {
		// TODO Auto-generated method stub
		if (count < 99)
			System.out.print(" ");
		if (count < 9)
			System.out.print(" ");
		System.out.print(++count + ". ");
		for (int j = 0; j < size; j++)
			System.out.print(arrCh[j]);
		System.out.print("   ");
		System.out.flush();
		if (count % 6 == 0)
			System.out.println("");

	}

	public static String getString() throws IOException {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String s = br.readLine();
		return s;
	}

}
