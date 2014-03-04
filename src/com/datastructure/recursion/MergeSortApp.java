package com.datastructure.recursion;

class DArray {
	int[] theArray;
	int n;

	public DArray(int size) {
		theArray = new int[size];
		n = 0;
	}

	public int size() {
		return n;
	}

	public void insert(int value) {
		theArray[n] = value;
		n++;
	}

	public void display() {
		for (int j = 0; j < n; j++)
			System.out.print(theArray[j] + " ");
		System.out.println();
	}

	public void mergeSort() {
		int workspace[] = new int[n];
		recMergeSort(workspace, 0, n - 1);
	}

	private void recMergeSort(int[] workspace, int lowerBound, int upperBound) {
		// TODO Auto-generated method stub

		if (lowerBound == upperBound)
			return;
		else {
			int mid = (lowerBound + upperBound) / 2;
			recMergeSort(workspace, lowerBound, mid);
			recMergeSort(workspace, mid + 1, upperBound);
			merge(workspace, lowerBound, mid + 1, upperBound);
		}

	}

	private void merge(int[] workspace, int lPtr, int highPtr, int upperBound) {
		// TODO Auto-generated method stub
		int lowerBound = lPtr;
		int mid = highPtr - 1;
		int j = 0;
		int no = upperBound - lowerBound + 1;

		while (lPtr <= mid && highPtr <= upperBound)
			if (theArray[lPtr] < theArray[highPtr])
				workspace[j++] = theArray[lPtr++];
			else
				workspace[j++] = theArray[highPtr++];

		while (lPtr <= mid)
			workspace[j++] = theArray[lPtr++];

		while (highPtr <= upperBound)
			workspace[j++] = theArray[highPtr++];

		for (int i = 0; i < no; i++)
			theArray[lowerBound + i] = workspace[i];

	}
}

public class MergeSortApp {

	public static void main(String[] args) {
		DArray arr = new DArray(100);// TODO Auto-generated method stub
		arr.insert(64); // insert items
		arr.insert(21);
		arr.insert(33);
		arr.insert(70);
		arr.insert(12);
		arr.insert(85);
		arr.insert(44);
		arr.insert(3);
		arr.insert(99);
		arr.insert(0);
		arr.insert(108);
		arr.insert(36);
		arr.display(); // display items
		arr.mergeSort(); // merge sort the array
		arr.display();

	}

}
