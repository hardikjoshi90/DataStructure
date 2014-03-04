package com.datastructure.sorting;

public class Unique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag = isUnique("naiya");
		System.out.println(flag);

	}

	public static boolean isUnique(String str) {

		char[] arrChar = new char[26];
		int[] arrInt = new int[26];
		for (int i = 0; i < str.length(); i++) {
			int idx = hash(str.charAt(i));
			if (arrInt[idx] == 0) {
				arrInt[idx] = 1;
			} else
				arrInt[idx] = arrInt[idx] + 1;
			arrChar[idx] = str.charAt(i);
		}

		for (int i = 0; i < str.length(); i++) {
			int key = hash(str.charAt(i));
			if (arrInt[key] > 1)
				return false;
		}
		return true;
	}

	public static int hash(char ch) {

		return ch - 'a';

	}
}
