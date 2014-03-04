package com.datastructure.sorting;

class ArrayInst {
	long[] a;
	int nElems;

	public ArrayInst(int size) {
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

	public void insertionSort() {
		for (int out = 1; out < nElems; out++) {
			long temp = a[out];
			int in = out;
			while (in > 0 && a[in - 1] > temp) {
				a[in] = a[in - 1];
				--in;
			}
			a[in] = temp;
			System.out.print("After Pass " + out + ": ");
			display();
		}
	}
}

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayInst arr = new ArrayInst(10);
		arr.insert(10);
		arr.insert(35);
		arr.insert(5);
		arr.insert(2);
		arr.insert(15);
		arr.insert(20);
		arr.insert(30);
		arr.display();
		arr.insertionSort();

	}

}
