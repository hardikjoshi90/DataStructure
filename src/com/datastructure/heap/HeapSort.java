package com.datastructure.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class hNode {
	int iData;

	public hNode(int key) {
		iData = key;
	}

	public int getKey() {
		return iData;
	}

	public void setKey(int id) {
		iData = id;
	}
}

class SHeap {
	hNode[] heapArray;
	int maxSize;
	int currentSize;

	public SHeap(int size) {
		heapArray = new hNode[size];
		maxSize = size;
		currentSize = 0;
	}

	public boolean insert(int key) {
		if (currentSize == maxSize)
			return false;
		hNode newNode = new hNode(key);
		heapArray[currentSize] = newNode;
		trickleUp(currentSize++);
		return true;
	}
	
	public void insertAt(int index,hNode newNode){
		heapArray[index]=newNode;
		
	}

	public void trickleUp(int index) {
		int parent = (index - 1) / 2;
		hNode bottom = heapArray[index];

		while (index > 0
				&& heapArray[parent].getKey() < bottom.getKey()) {
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (index - 1) / 2;
		}

		heapArray[index] = bottom;
	}

	public hNode remove() {
		hNode root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return root;
	}

	public void trickleDown(int index) {
		int largerChild;
		hNode top = heapArray[index];

		while (index < currentSize / 2) {
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;

			if (rightChild < currentSize
					&& heapArray[leftChild].getKey() < heapArray[rightChild]
							.getKey())
				largerChild = rightChild;
			else
				largerChild = leftChild;

			if (top.getKey() >= heapArray[largerChild].getKey())
				break;
			heapArray[index] = heapArray[largerChild];
			index = largerChild;
		}

		heapArray[index] = top;
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public void displayArray() {
		System.out.print("heapArray: ");
		for (int j = 0; j < maxSize; j++) {
			if (heapArray[j] != null)
				System.out.print(heapArray[j].getKey() + " ");
			else
				System.out.println("-- ");
		}
		System.out.println();

	}

	public boolean change(int index, int value) {
		if (index < 0 || index >= currentSize)
			return false;
		int oldValue = heapArray[index].getKey();
		heapArray[index].setKey(value);

		if (oldValue < value)
			trickleUp(index);
		else
			trickleDown(index);
		return true;
	}

	public void incrementSize() {
		// TODO Auto-generated method stub
		currentSize++;
	}
}

public class HeapSort {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int size, j;
		System.out.print("Enter number of items: ");
		size = getInt();
		SHeap theHeap = new SHeap(size);
		for(j=0; j<size; j++) // fill array with
		{ // random nodes
		int random = (int)(java.lang.Math.random()*100);
		hNode newNode = new hNode(random);
		theHeap.insertAt(j, newNode);
		theHeap.incrementSize();
		}
		System.out.print("Random: ");
		theHeap.displayArray(); // display random array
		for(j=size/2-1; j>=0; j--) // make random array into heap
		theHeap.trickleDown(j);
		System.out.print("Heap: ");
		theHeap.displayArray(); // display heap array
		for(j=size-1; j>=0; j--) // remove from heap and
		{ // store at array end
		hNode biggestNode = theHeap.remove();
		theHeap.insertAt(j, biggestNode);
		}
		System.out.print("Sorted: ");
		theHeap.displayArray();

	}
	
	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}

}
