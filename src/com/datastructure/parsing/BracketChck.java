package com.datastructure.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StckX {
	private int maxsize;
	private int top;
	private char[] charray;

	public StckX(int s) {
		maxsize = s;
		charray = new char[maxsize];
		top = -1;
	}

	public void push(char j) {
		charray[++top] = j;
	}

	public char pop() {

		return charray[top--];
	}

	public char peek() {
		return charray[top];
	}

	public boolean isempty() {
		return (top == -1);
	}

}

class brakt {
	private String input;

	public brakt(String in) {
		input = in;
	}

	public void check() {
		int stacksize = input.length();
		StckX stck = new StckX(stacksize);
		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);
			switch (ch) {
			case '{':
			case '[':
			case '(':
				stck.push(ch);
				break;
			case '}':
			case ']':
			case ')':
				if (!stck.isempty()) {
					char chx = stck.pop();
					if ((chx != '{' && ch == '}') || (chx != '[' && ch == ']')
							|| (chx != '(' && ch == ')'))

						System.out.println("error");

				} else {
					System.out.println("error");
				}
				break;
			default:
				break;

			}

		}
		if (!stck.isempty()) {
			System.out.println("Error: Missing right delimiter");
		}
	}

}

public class BracketChck {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String input;
		while (true) {
			System.out.println("Entr a ng");
			System.out.flush();
			input = getString();
			brakt bk = new brakt(input);
			bk.check();
		}
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str = br.readLine();
		return str;
	}
}