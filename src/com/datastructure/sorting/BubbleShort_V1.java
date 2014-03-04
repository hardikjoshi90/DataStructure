package com.datastructure.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleShort_V1 {

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
		
		long start = System.currentTimeMillis();
		bubbleSort(array);
		long end = System.currentTimeMillis();
		
		long total = end - start;
		
		System.out.println("\nTime: "+total);

	}
	
	public static void bubbleSort(int a[]){
		int out=a.length-1;
		int [][] arr= new int [6][3];
		int row = arr.length;
		int col =arr[0].length;
		
		System.out.println("row:"+row +" & col:"+col);
		
		int n=0;
		while (out>0){
			if(n>=out){
				n=0;
				out = out-1;
			}
			else if(a[n]>a[n+1]){
				int temp = a[n];
				a[n]=a[n+1];
				a[n+1] = temp;
				n=n+1;
			}
			else{
				n++;
			}
		}
		System.out.print("\nSorted Array:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
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
