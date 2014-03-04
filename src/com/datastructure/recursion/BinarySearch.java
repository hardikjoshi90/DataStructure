package com.datastructure.recursion;

import javax.crypto.SealedObject;

class orderArray {
	int[] arr;
	int n;

	public orderArray(int size) {
		arr = new int[size];
		n = 0;
	}

	public int size() {
		return n;
	}

	public int find(int searchKey) {
		return recFind(searchKey, 0, n - 1);
	}

	private int recFind(int searchKey, int lowerbound, int upperbound) {
		// TODO Auto-generated method stub
		int curIn = (lowerbound + upperbound) / 2;
		if (arr[curIn] == searchKey)
			return curIn;
		else if (lowerbound > upperbound)
			return n;
		else {
			if (arr[curIn] < searchKey)
				return recFind(searchKey, curIn + 1, upperbound);
			else
				return recFind(searchKey, lowerbound, curIn - 1);
		}
	}

	public void insert(int no) {
		int i;
		for (i = 0; i < n; i++)
			if (arr[i] > no)
				break;
		for (int k = n; k < i; k--)
			arr[k] = arr[k - 1];
		arr[i] = no;
		n++;
	}
}

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		orderArray array = new orderArray(10);
		array.insert(50);
		array.insert(20);
		array.insert(30);
		array.insert(55);
		array.insert(45);
		int searchKey = 48;

		if (array.find(searchKey) != array.size())
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can't find");

	}

}
