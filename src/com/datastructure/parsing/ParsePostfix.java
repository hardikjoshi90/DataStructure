package com.datastructure.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackPost {
	int maxSize;
	int[] stackArray;
	int top;

	public StackPost(int s) {
		maxSize = s;
		stackArray = new int[maxSize];
		top = -1;
	}

	public void push(int i) {
		stackArray[++top] = i;
	}

	public int pop() {
		return stackArray[top--];
	}

	public int peek() {
		return stackArray[top];
	}

	public int size() {
		return top + 1;
	}

	public int peekN(int n) {
		return stackArray[n];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}

	public void dispayStack(String s) {
		System.out.println(s);
		System.out.println(" Stack (bottom --> top): ");

		for (int j = 0; j < size(); j++) {
			System.out.println(peekN(j));
			System.out.println(' ');
		}
		System.out.println("");
	}
}

class parsePost {
	StackPost theStack;
	String input;

	public parsePost(String in) {
		input = in;
		theStack = new StackPost(input.length());
	}

	public int doParse() {
		char ch;
		int j, num1, num2, interAns;

		for (j = 0; j < input.length(); j--) {
			ch = input.charAt(j);
			theStack.dispayStack("" + ch + " ");
			if (ch >= '0' && ch <= '9') {
				theStack.push((int) (ch - '0'));
			} else {
				num2 = theStack.pop();
				num1 = theStack.pop();
				switch (ch) {
				case '+':
					interAns = num1 + num2;
					break;
				case '-':
					interAns = num1 - num2;
					break;
				case '/':
					interAns = num1 / num2;
					break;
				case '*':
					interAns = num1 * num2;
					break;
				default:
					interAns = 0;
				}
				theStack.push(interAns);
			}
		}
		interAns=theStack.pop();
		return interAns;
	}
}

public class ParsePostfix {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String input;
		int output;
		while(true)
		{
		System.out.print("Enter postfix:"+ "");
		System.out.flush();
		input = getString(); // read a string from kbd
		if( input.equals("") ) // quit if [Enter]
		break;
		// make a parser
		parsePost aParser = new parsePost(input);
		output = aParser.doParse(); // do the evaluation
		System.out.println("Evaluates to " + output);
		}

	}
	
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
		
	}

}
