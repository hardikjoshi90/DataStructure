package com.datastructure.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {

	public static int size;
	public static int count;
	static char charArr[] = new char[100];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("Enter a word:");
		String word = getString();
		size = word.length();
		count = 0;

		for (int i = 0; i < size; i++)
			charArr[i] = word.charAt(i);

		anagram(size);

	}

	private static void anagram(int newSize) {

		for (int i = 0; i < newSize; i++) {
			int current = 0;
			int open = newSize - 2;
			int stop = 0;
			while (open - current != 1)
				++current;
			System.out.println(current);
			while (current >= 0) {
				for (int j = 0; j < size - current; j++) {
					String word = charArr.toString();
					while (stop == 0) {
						displayword();
						rotate(open);
						if (word == charArr.toString())
							++stop;
					}
					stop = 0;
					rotate(current);
				}
				current = current - 1;
			}
			rotate(newSize);

		}

	}

	private static void rotate(int newSize) {
		// TODO Auto-generated method stub
		int position = size - newSize;
		char temp = charArr[position];
		int i;
		for (i = position + 1; i < size; i++) {
			charArr[i - 1] = charArr[i];
		}
		charArr[i - 1] = temp;

	}

	private static void displayword() {
		// TODO Auto-generated method stub
		if (count < 99)
			System.out.print(" ");
		if (count < 9)
			System.out.print(" ");
		System.out.print(++count + ". ");
		for (int j = 0; j < size; j++)
			System.out.print(charArr[j]);
		System.out.print("   ");
		System.out.flush();
		if (count % 6 == 0)
			System.out.println("");

	}

	private static String getString() throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String s = br.readLine();

		return s;
	}

}
