package com.datastructure.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSortApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("Enter the size of array");
		int size = getInt();
		int array[] = new int[size];
		System.out.print("Unsorted Array:");
		for (int i = 0; i < size; i++) {
			array[i] = (int) (Math.random() * 100);
			System.out.print(array[i] + " ");
		}

		Sort(array, 0, size - 1);
		
System.out.print("\nSorted Array:");
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
		}

	}

	public static void Sort(int a[], int lo, int hi) {

		if (hi == lo)
			return;
		int mid = (lo + hi) / 2;
		Sort(a, lo, mid);
		Sort(a, mid + 1, hi);
		merge(a, lo, mid + 1, hi);

	}

	private static void merge(int[] a, int lptr, int hptr, int ub) {
		// TODO Auto-generated method stub
		int k = 0;
		int lb = lptr;
		int mid = hptr - 1;
		int n = ub - lb + 1;
		int aux[] = new int[n];
		while (lb <= mid && hptr <= ub)
			if (a[lptr] < a[hptr])
				aux[k++] = a[lptr++];
			else
				aux[k++] = a[hptr++];
		while (lptr <= mid)
			aux[k++] = a[lptr++];
		while (hptr <= ub)
			aux[k++] = a[hptr++];
		for (int l = 0; l < n; l++)
			a[lb + l] = aux[l];
	}

	private static int getInt() throws IOException {
		// TODO Auto-generated method stub
		String s = getString();
		return Integer.parseInt(s);
	}

	private static String getString() throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

}
