package com.pckg.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Minesweeper {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String sCurrentLine;
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		while ((sCurrentLine = br.readLine()) != null) {
			String[] values = sCurrentLine.split(";");
			String[] size = values[0].split(",");
			int row = Integer.parseInt(size[0]);
			int col = Integer.parseInt(size[1]);
			String output = getAdjacentMines(values[1], row, col);
			System.out.println(output);

		}

	}

	private static String getAdjacentMines(String input, int r, int c) {
		// TODO Auto-generated method stub
		int len = input.length();
		char[][] arr = new char[r][c];
		String output = "";
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				arr[i][j] = input.charAt(c * i + j);

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] == '*')
					output = output + "*";
				else {
					int cnt = getAdjCount(arr, i, j);
					output = output + cnt;
				}
			}
		}
		return output;
	}

	private static int getAdjCount(char[][] arr, int i, int j) {
		// TODO Auto-generated method stub
		int count = 0;
		if (i == 0) {
			if (j == 0) {
				if (arr[i + 1][j] == '*')
					count = count + 1;
				if (arr[i + 1][j + 1] == '*')
					count = count + 1;
				if (arr[i][j + 1] == '*')
					count = count + 1;
			} else if (j == arr[0].length - 1) {
				if (arr[i][j - 1] == '*')
					count = count + 1;
				if (arr[i + 1][j - 1] == '*')
					count = count + 1;
				if (arr[i + 1][j] == '*')
					count = count + 1;
			}

			else if (j > 0 && j < arr[0].length - 1) {
				if (arr[i + 1][j] == '*')
					count = count + 1;
				if (arr[i + 1][j + 1] == '*')
					count = count + 1;
				if (arr[i][j + 1] == '*')
					count = count + 1;
				if (arr[i][j - 1] == '*')
					count = count + 1;
				if (arr[i + 1][j - 1] == '*')
					count = count + 1;
			}
		}

		else if (j == 0) {
			if (i < arr.length - 1) {
				if (arr[i - 1][j] == '*')
					count = count + 1;
				if (arr[i + 1][j] == '*')
					count = count + 1;
				if (arr[i - 1][j + 1] == '*')
					count = count + 1;
				if (arr[i + 1][j + 1] == '*')
					count = count + 1;
				if (arr[i][j + 1] == '*')
					count = count + 1;
			} else {
				if (arr[i][j + 1] == '*')
					count = count + 1;
				if (arr[i - 1][j] == '*')
					count = count + 1;
				if (arr[i - 1][j + 1] == '*')
					count = count + 1;

			}
		}

		else if (j == arr[0].length - 1) {
			if (i == arr.length - 1) {
				if (arr[i][j - 1] == '*')
					count = count + 1;
				if (arr[i - 1][j] == '*')
					count = count + 1;
				if (arr[i - 1][j - 1] == '*')
					count = count + 1;
			} else {
				if (arr[i - 1][j] == '*')
					count = count + 1;
				if (arr[i + 1][j] == '*')
					count = count + 1;
				if (arr[i - 1][j - 1] == '*')
					count = count + 1;
				if (arr[i + 1][j - 1] == '*')
					count = count + 1;
				if (arr[i][j - 1] == '*')
					count = count + 1;
			}
		} else if (i == arr.length - 1) {
			if (arr[i - 1][j - 1] == '*')
				count = count + 1;
			if (arr[i - 1][j] == '*')
				count = count + 1;
			if (arr[i - 1][j + 1] == '*')
				count = count + 1;
			if (arr[i][j - 1] == '*')
				count = count + 1;
			if (arr[i][j + 1] == '*')
				count = count + 1;
		} else {
			if (arr[i - 1][j - 1] == '*')
				count = count + 1;
			if (arr[i - 1][j] == '*')
				count = count + 1;
			if (arr[i - 1][j + 1] == '*')
				count = count + 1;
			if (arr[i + 1][j + 1] == '*')
				count = count + 1;
			if (arr[i + 1][j] == '*')
				count = count + 1;
			if (arr[i + 1][j - 1] == '*')
				count = count + 1;
			if (arr[i][j - 1] == '*')
				count = count + 1;
			if (arr[i][j + 1] == '*')
				count = count + 1;
		}
		return count;
	}

}
