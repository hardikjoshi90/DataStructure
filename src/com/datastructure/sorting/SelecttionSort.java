package com.datastructure.sorting;

class ArraySel {
	long[] a;
	int nElems;

	public ArraySel(int size) {
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

	public void selectionSort() {
		for (int out = 0; out < nElems; out++) {
			int min = out;
			for (int in = out + 1; in < nElems; in++)
				if (a[in] < a[min])
					min = in;
			swap(out, min);
			System.out.print("After Pass " + (out + 1) + ": ");
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

public class SelecttionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArraySel arr = new ArraySel(10);
		arr.insert(10);
		arr.insert(35);
		arr.insert(5);
		arr.insert(2);
		arr.insert(15);
		arr.insert(20);
		arr.insert(30);
		arr.display();
		arr.selectionSort();

	}

}
