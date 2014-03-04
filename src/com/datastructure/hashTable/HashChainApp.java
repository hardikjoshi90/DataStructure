package com.datastructure.hashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Link {
	int iData;
	Link next;

	public Link(int iData) {
		this.iData = iData;
	}

	public int getKey() {
		return this.iData;
	}

	public void displayLink() {
		System.out.print(this.iData + " ");
	}
}

class SortedList {
	Link first;

	public SortedList() {
		first = null;
	}

	public void insert(Link theLink) {
		Link previous = null;
		Link current = first;
		int key = theLink.getKey();

		while (current != null && key > current.getKey()) {
			previous = current;
			current = current.next;
		}

		if (previous == null)
			first = theLink;
		else
			previous.next = theLink;
		theLink.next = current;

	}

	public Link find(int key) {
		Link current = first;
		while (current != null && current.getKey() <= key) {
			if (key == current.getKey())
				return current;
			current = current.next;
		}

		return null;
	}

	public void delete(int key) {
		Link current = first;
		Link previous = null;
		while (current != null && current.getKey() != key) {
			previous = current;
			current = current.next;
		}
		if (previous == null)
			first = first.next;
		else
			previous.next = current.next;
	}

	public void displayList() {
		Link current = first;
		System.out.print("List (first --> Last):");
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
}

class HashTable1 {

	int arraySize;
	SortedList[] hashArray;

	public HashTable1(int size) {
		hashArray = new SortedList[size];
		arraySize = size;
		for(int j=0;j<arraySize;j++)
			hashArray[j]=new SortedList();
	}

	public int hashFunc(int key) {
		return key % arraySize;
	}

	public void insert(Link theLink) {
		
		int key = theLink.getKey();
		int hashVal = hashFunc(key);
		hashArray[hashVal].insert(theLink);
	}
	
	public void delete(int key){
		int hashVal = hashFunc(key);
		hashArray[hashVal].delete(key);
	}
	
	public Link find(int key){
		int hashVal = hashFunc(key);
		Link theLink = hashArray[hashVal].find(key);
		return theLink;
	}
	
	public void displayTable(){
		for(int j=0;j<arraySize;j++){
			System.out.print(j+". ");
			hashArray[j].displayList();
		}
		
	}
}

public class HashChainApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Link aDataItem;
		int aKey, size, n, keysPerCell;

		System.out.println("Enter size of HashTable");
		size = getInt();
		System.out.println("Enter Intial number of Items");
		n = getInt();

		keysPerCell = 100;
		HashTable1 theHashTable = new HashTable1(size);

		for (int j = 0; j < n; j++) {
			aKey = (int) (java.lang.Math.random() * keysPerCell * size);
			aDataItem = new Link(aKey);
			theHashTable.insert(aDataItem);
		}
		while (true) {
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, delete or find: ");
			char ch = getChar();

			switch (ch) {
			case 's':
				theHashTable.displayTable();
				break;
			case 'i':
				System.out.println("Enter key value to insert: ");
				aKey = getInt();
				aDataItem = new Link(aKey);
				theHashTable.insert(aDataItem);
				break;
			case 'f':
				System.out.println("Enetr key value to find: ");
				aKey = getInt();
				aDataItem = theHashTable.find(aKey);
				if (aDataItem != null)
					System.out.println("Found Key: " + aKey);
				else
					System.out.println("Key not found!");
				break;
			case 'd':
				System.out.println("Enter key value to delete: ");
				aKey = getInt();
				theHashTable.delete(aKey);
				break;
			default:
				System.out.print("Invalid Key Entry\n");
			}
		}

	}
	
	private static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String s = br.readLine();
		return s;
	}

	private static int getInt() throws IOException {
		// TODO Auto-generated method stub
		String s = getString();
		return Integer.parseInt(s);
	}

	private static char getChar() throws IOException {
		// TODO Auto-generated method stub
		String s = getString();
		return s.charAt(0);
	}

}
