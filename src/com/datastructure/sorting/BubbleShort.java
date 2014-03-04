package com.datastructure.sorting;

class ArrayBub {
	long[] a;
	int nElems;

	public ArrayBub(int size) {
		a = new long[size];
		nElems = 0;
	}

	public void insert(int value) {
		a[nElems] = value;
		nElems++;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public void bubbleShort() {

		for (int out = nElems - 1; out > 1; out--) {
			for (int in = 0; in < out; in++)
				if (a[in] > a[in + 1])
					swap(in, in + 1);
			System.out.print("After Pass " + (nElems - out) + ": ");
			display();
		}
	}

	private void swap(int i, int j) {
		// TODO Auto-generated method stub
		long temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}
}

public class BubbleShort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayBub arr = new ArrayBub(20);
		arr.insert(10);
		arr.insert(35);
		arr.insert(5);
		arr.insert(2);
		arr.insert(15);
		arr.insert(20);
		arr.insert(30);
		arr.insert(50);
		arr.insert(50);
		arr.insert(50);
		arr.insert(50);
		arr.insert(50);
		arr.display();
		long start = System.currentTimeMillis();
		arr.bubbleShort();
		long end = System.currentTimeMillis();

		long total = end - start;

		System.out.println("\nTime: " + total);

	}

}
