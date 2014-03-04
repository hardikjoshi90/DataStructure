package com.datastructure.queue;

class Q {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;

	// --------------------------------------------------------------
	public Q(int s) // constructor
	{
		maxSize = s + 1; // array is 1 cell larger
		queArray = new long[maxSize]; // than requested
		front = 0;
		rear = -1;
	}

	// --------------------------------------------------------------
	public void insert(long j) // put item at rear of queue
	{
		if (!isFull()) {
			if (rear == maxSize - 1)
				rear = -1;
			queArray[++rear] = j;
		}
		else
		{
			System.out.println("Front is"+front);
			System.out.println("Rear is"+rear);
			System.out.println("Queue is Full");
		}
	}

	// --------------------------------------------------------------
	public long remove() // take item from front of queue
	{
		long temp=0;
		if (!isEmpty()) {
			temp = queArray[front++];
			if (front == maxSize)
				front = 0;
		}
		else
		{
			System.out.println("Front is"+front);
			System.out.println("Rear is"+rear);
			System.out.println("Queue is Empty");
		}
		return temp;
	}

	// --------------------------------------------------------------
	public long peek() // peek at front of queue
	{
		return queArray[front];
	}

	// --------------------------------------------------------------
	public boolean isEmpty() // true if queue is empty
	{
		return (rear + 1 == front || (front + maxSize - 1 == rear));
	}

	// --------------------------------------------------------------
	public boolean isFull() // true if queue is full
	{
		return (rear + 2 == front || (front + maxSize - 2 == rear));
	}

	// --------------------------------------------------------------
	public int size() // (assumes queue not empty)
	{
		if (rear >= front) // contiguous sequence
			return rear - front + 1;
		else
			// broken sequence
			return (maxSize - front) + (rear + 1);
	}

}

public class Queue1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Q theQueue = new Q(4);
		theQueue.insert(10);
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(40);
		theQueue.remove();
		theQueue.insert(30);
		theQueue.insert(30);
		theQueue.remove();
		theQueue.insert(30);
		theQueue.insert(30);		
	}
}