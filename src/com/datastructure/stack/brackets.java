package com.datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Stackbr {
	char[] stackArray;
	int maxSize;
	int top;

	public Stackbr(int s) {
		maxSize = s;
		stackArray = new char[maxSize];
		top = -1;
	}

	public void push(char ch) {
		stackArray[++top] = ch;
	}

	public char pop() {
		return stackArray[top--];
	}

	public char peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize);
	}
}

class brchecker {

	String input;

	public brchecker(String in) {
		input = in;
	}

	public void check() {
		int StackSize = input.length();
		Stackbr theStack = new Stackbr(StackSize);

		for (int j = 0; j < StackSize; j++) {
			char ch = input.charAt(j);
			switch (ch) {
			case '{':
			case '[':
			case '(':
				theStack.push(ch);
				break;

			case '}':
			case ']':
			case ')':
				if (!theStack.isEmpty()) {
					char chx = theStack.pop();
					if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[')
							|| (ch == ')' && chx != '(')) {
						System.out.println("Error " + ch + " at " + j);
					}

				} else {
					System.out.println("Error " + ch + " at " + j);
				}
				break;

			default:
				break;
			}
		}
		if (!theStack.isEmpty()) {
			System.out.println("Error: Missing right delimiter");
		}
	}
}

public class brackets {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String input;
		while (true) {
			System.out.println("Enter string containing delimiter:");
			System.out.flush();
			
			input = getString();
			
			if(input.equals("")){
				break;
			}
			brchecker chk = new brchecker(input);
			chk.check();
		}
	}
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}