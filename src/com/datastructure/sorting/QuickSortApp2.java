package com.datastructure.sorting;

class ArrayQk {

	int theArray[];
	int nElem;
	static int count=1;

	public ArrayQk(int max) {
		theArray = new int[max];
		nElem = 0;
	}

	public void insert(int value) {
		theArray[nElem] = value;
		nElem++;
	}

	public void display() {
		for (int j = 0; j < nElem; j++) {
			System.out.print(theArray[j] + " ");
		}
		System.out.println("");
	}

	public void quickSort() {
		recQuickSort(0, nElem - 1);
	}

	public void recQuickSort(int left, int right) {
		// TODO Auto-generated method stub

		int size = right - left + 1;
		

		if (size <= 3)
			manualSort(left, right);
		else {
			int median = medianOf3(left, right);
			int partition = partitionIt(left, right, median);
			System.out.print("After Pass "+count+": ");
			display();
			count++;
			recQuickSort(0, partition - 1);
			recQuickSort(partition + 1, right);
		}

	}

	private int partitionIt(int left, int right, int pivot) {
		// TODO Auto-generated method stub
		int leftPtr = left;
		int rightPtr = right - 1;
		while (true) {
			while (theArray[++leftPtr] < pivot)
				;
			while (theArray[--rightPtr] > pivot)
				;
			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right - 1);
		
		return leftPtr;
	}

	public int medianOf3(int left, int right) {
		// TODO Auto-generated method stub
		int center = (left + right) / 2;

		if (theArray[left] > theArray[right])
			swap(left, right);

		if (theArray[left] > theArray[center])
			swap(left, center);
		if (theArray[center] > theArray[right])
			swap(center, right);

		swap(center, right - 1);
		return theArray[right - 1];
	}

	public void swap(int one, int two) {
		// TODO Auto-generated method stub
		int temp = theArray[one];
		theArray[one] = theArray[two];
		theArray[two] = temp;
	}

	private void manualSort(int left, int right) {
		// TODO Auto-generated method stub
		int size = right - left + 1;
		
		if(size == 1)
			return;
		if(size == 2){
			if(theArray[left]>theArray[right])
				swap(left,right);
			return;
		}
		else{
			int center = (left+right)/2;
			if(theArray[left]>theArray[right])
				swap(left,right);
			if(theArray[left]>theArray[center])
				swap(left,center);
			if(theArray[center]>theArray[right])
				swap(center,right);
		}
		System.out.print("After Pass "+count+": ");
		display();
		count++;
	}

}

public class QuickSortApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxSize = 16; // array size
		ArrayQk arr; // reference to array
		arr = new ArrayQk(maxSize); // create the array
	
		for(int j=0; j<maxSize; j++) // fill array with
		{ // random numbers
		int n = (int)(java.lang.Math.random()*99);
		arr.insert(n);
		}
		System.out.print("Unsorted Array: ");
		arr.display(); // display items
		arr.quickSort(); // quicksort them
		System.out.print("Sorted Array: ");
		arr.display();

	}

}
