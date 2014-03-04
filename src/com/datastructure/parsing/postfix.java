package com.datastructure.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackP {
	int maxSize;
	char[] stackArray;
	int top;

	public StackP(int s) {
		maxSize = s;
		stackArray = new char[maxSize];
		top = -1;
	}

	public void push(char i) {
		stackArray[++top] = i;
	}

	public char pop() {
		return stackArray[top--];
	}

	public char peek() {
		return stackArray[top];
	}

	public int size() {
		return top + 1;
	}

	public char peekN(int n) {
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

class InToPost {
	StackP theStack;
	String input;
	String output = "";

	public InToPost(String in) {
		input = in;
		int stackSize = input.length();
		theStack = new StackP(stackSize);
	}

	public String doTrans() {

		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);
			theStack.dispayStack("For char " + ch + " ");

			switch (ch) {
			case '+':
			case '-':
				gotOper(ch, 1);
				break;

			case '*':
			case '/':
				gotOper(ch, 2);
				break;
			case '(':
				theStack.push(ch);
				break;
			case ')':
				gotParen(ch);
				break;
			default:
				output = output + ch;
				break;

			}
		}
		while (!theStack.isEmpty()) {
			theStack.dispayStack("While ");
			output = output + theStack.pop();
		}
		theStack.dispayStack("End ");
		return output;
	}

	public void gotOper(char opThis, int prec1) {
		while (!theStack.isEmpty()) {
			char opTop = theStack.pop();

			if (opTop == '(') {
				theStack.push(opTop);
				break;
			} else {
				int prec2;
				if (opTop == '+' || opTop == '-') {
					prec2 = 1;
				} else {
					prec2 = 2;
				}

				if (prec2 < prec1) {
					theStack.push(opTop);
					break;
				} else
					output = output + opTop;
			}
		}
		theStack.push(opThis);
	}

	public void gotParen(char ch) {
		while (!theStack.isEmpty()) {
			char chx = theStack.pop();
			if (chx == '(')
				break;
			else
				output = output + chx;
		}
	}
}

public class postfix {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String input, output;
		while (true) {
			System.out.print("Enter infix: ");
			System.out.flush();
			input = getString(); // read a string from kbd
			boolean flagin = chkInput(input);
			if (input.equals("")) // quit if [Enter]
				break;
			// make a translator
			if (!flagin) {
				InToPost theTrans = new InToPost(input);
				output = theTrans.doTrans(); // do the translation
				System.out.println("Postfix is " + output + '\n');
			}
			else{
				System.out.println("Enter valid infix");
			}
		} // end while
	} // end main()
		// --------------------------------------------------------------

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static boolean chkInput(String in) {
		boolean flag = false;
		for (int j = 0; j < in.length() - 1; j++) {

			char ch = in.charAt(j);
			char chx = in.charAt(j + 1);

			if ((ch >= '0' && ch <= '9') && (chx >= '0' && chx <= '9')) {
				flag = true;
			} 
		}
		return flag;
	}

}
