package com.datastructure.hashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.print.attribute.HashAttributeSet;

class DataItem {

	private int iData;

	public DataItem(int key) {
		iData = key;
	}

	public int getKey() {
		return iData;
	}
}

class HashTable {
	DataItem[] hashArray;
	int arraySize;
	DataItem nonItem;

	public HashTable(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);
	}

	public void displayTable() {
		System.out.println("Table: ");
		for (int j = 0; j < arraySize; j++) {
			if (hashArray[j] != null)
				System.out.print(hashArray[j].getKey() + " ");
			else
				System.out.print("** ");
		}
		System.out.println("");
	}

	public int hashFunc(int key) {
		return key % arraySize;
	}

	public void insert(DataItem item) {
		int key = item.getKey();
		int hashVal = hashFunc(key);

		while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
			++hashVal;
			hashVal %= arraySize;
		}
		hashArray[hashVal] = item;
	}

	public DataItem find(int aKey) {
		int hashVal = hashFunc(aKey);

		while (hashArray[hashVal] != null) {
			if (hashArray[hashVal].getKey() == aKey)
				return hashArray[hashVal];
			++hashVal;
			hashVal %= arraySize;
		}
		return null;
	}

	public DataItem delete(int aKey) {

		int hashVal = hashFunc(aKey);

		while (hashArray[hashVal] != null) {
			if (hashArray[hashVal].getKey() == aKey) {
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return temp;
			}
			++hashVal;
			hashVal %= arraySize;
		}

		return null;

	}
}

public class HashTableApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataItem aDataItem;
		int aKey, size, n, keysPerCell;

		System.out.println("Enter size of HashTable");
		size = getInt();
		System.out.println("Enter Intial number of Items");
		n = getInt();

		keysPerCell = 10;
		HashTable theHashTable = new HashTable(size);

		for (int j = 0; j < n; j++) {
			aKey = (int) (java.lang.Math.random() * keysPerCell * size);
			aDataItem = new DataItem(aKey);
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
				aDataItem = new DataItem(aKey);
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
				aDataItem = theHashTable.delete(aKey);
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
