package com.datastructure.sorting;

class ShArr {

	int[] theArray;
	int nElm;

	public ShArr(int max) {
		theArray = new int[max];
		nElm = 0;
	}

	public void insert(int value) {
		theArray[nElm] = value;
		nElm++;
	}

	public void display() {
		for (int i = 0; i < nElm; i++)
			System.out.print(theArray[i] + " ");
		System.out.println("");
	}

	public void shellSort() {
		int inner, outer, temp, h;
		h = 1;
		int count = 1;

		while (h <= nElm / 3)
			h = 3 * h + 1;
		while (h > 0) {
			for (outer = h; outer < nElm; outer++) {

				temp = theArray[outer];
				inner = outer;

				while (inner > h - 1 && theArray[inner - h] >= temp) {
					theArray[inner] = theArray[inner - h];
					inner = inner - h;
				}

				theArray[inner] = temp;
			}
			System.out.print("After Pass " + count + ":");
			display();
			count++;
			h = (h - 1) / 3;
		}

	}
}

public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShArr arr = new ShArr(10);
		for (int j = 0; j < 10; j++) // fill array with
		{ // random numbers
			int n = (int) (java.lang.Math.random() * 99);
			arr.insert(n);
		}
		System.out.print("Unsorted Array: ");
		arr.display(); // display unsorted array
		arr.shellSort(); // shell sort the array
		System.out.print("Sorted Array: ");
		arr.display();

	}

}
