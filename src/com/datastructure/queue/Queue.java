package com.datastructure.queue;

class QueueExmpl {

	int maxSize;
	int[] QueueArray;
	int front;
	int rear;
	int nItems;

	public QueueExmpl(int s) {
		maxSize = s;
		QueueArray = new int[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public void insert(int i) {
		if (rear == maxSize - 1)
			rear = -1;
		if (!isFull()) {
			QueueArray[++rear] = i;
			nItems += 1;
		} else {
			System.out.println("Queue is full");
		}
	}

	public int remove() {
		int temp = 0;
		if (!isEmpty()) {
			temp = QueueArray[front++];
			if (front == maxSize)
				front = 0;
			nItems--;
		} else {
			System.out.println("Queue is Empty");
		}

		return temp;
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	public int peekFront() {
		return QueueArray[front];
	}
	
	public void displayQueue(){
		for(int j=front;j<nItems;j++){
			System.out.println(QueueArray[j]);
		}
		for(int j=0;j<=rear;j++){
			System.out.println(QueueArray[j]);
		}
	}
}

public class Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueExmpl theQueue = new QueueExmpl(5);
		theQueue.insert(10);
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(40);
		theQueue.remove();
		theQueue.remove();
		theQueue.remove();
		theQueue.insert(50);
		theQueue.insert(60);
		theQueue.insert(70);
		theQueue.insert(80);
		theQueue.remove();
		theQueue.remove();
		int n = theQueue.peekFront();
		//System.out.println(n);
		theQueue.displayQueue();

	}

}
