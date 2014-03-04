package com.datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackX
{
	int []theStack;
	int maxSize;
	int top;
	
	StackX(int Size)
	{
		maxSize = Size;
		theStack = new int[maxSize];
		top = -1;
		
	}
	
	public void push(int i)
	{
		theStack[++top] = i;
	}
	
	public int pop()
	{
		return theStack[top--];
	}
	
	public int peek()
	{
		return theStack[top];
	}
	
	public boolean isEmpty()
	{
		return (top==-1);
	}
	
	public boolean isFull()
	{
		return (top==maxSize);
	}
}


class StackX1
{
	char []theStack;
	int maxSize;
	int top;
	
	StackX1(int Size)
	{
		maxSize = Size;
		theStack = new char[maxSize];
		top = -1;
		
	}
	
	public void push(char ch)
	{
		theStack[++top] = ch;
	}
	
	public char pop()
	{
		return theStack[top--];
	}
	
	public char peek()
	{
		return theStack[top];
	}
	
	public boolean isEmpty()
	{
		return (top==-1);
	}
	
	public boolean isFull()
	{
		return (top==maxSize);
	}
}

class Reverser
{
	private String input;
	private String output;
	
	public Reverser(String in)
	{
		input=in;
	}
	
	public String doRev()
	{
		int StackSize = input.length();
		StackX1 theStack = new StackX1(StackSize);
		
		for (int j=0;j<StackSize;j++)
		{
			theStack.push(input.charAt(j));
		}
		
		output="";
		while(!theStack.isEmpty())
		{
			char ch = theStack.pop();
			output+=ch;
		}
		return output;
	}
	
}


public class MyStack {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		StackX st = new StackX(10);
		StackX stCopy = new StackX(10);
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		System.out.println("Stack Elements:");
		for (int i=0;i<=st.top;i++)
		{
			System.out.println(st.theStack[i]);
		}
		System.out.println("Top is on element:"+st.peek());
		
		/*while(!st.isEmpty())
		{
			int val = st.pop();
			System.out.println("Popped element is:"+val);
		}*/
		
		stCopy = st;
		String input,output;
		System.out.println("Copy of Stack:");
		for (int i=0;i<=stCopy.top;i++)
		{
			stCopy.theStack[i] = i;
			System.out.println(stCopy.theStack[i]);
		}
		
		System.out.println("Making Change in copy, Original Stack is:");
		for (int i=0;i<=st.top;i++)
		{
			System.out.println(st.theStack[i]);
		}
		/*while(true)
		{
			System.out.println("Enter String:");
			System.out.flush();
			input=getString();
			if(input.equals(""))
			{
				break;
			}
			
			Reverser theReverser = new Reverser(input);
			output = theReverser.doRev();
			System.out.println("Reversed:"+output);
		}*/
		
		
	}
	public static String getString() throws IOException
	{
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	String s = br.readLine();
	return s;
	}

}
