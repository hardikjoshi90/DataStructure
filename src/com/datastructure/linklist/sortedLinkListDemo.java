package com.datastructure.linklist;

class SLink {
	int data;
	SLink next;

	public SLink(int d) {
		data = d;
	}
	
	public void displayLink(){
		System.out.println(data);
	}
}

class SLinkList {
	public SLink first;

	public SLinkList() {
		first = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insert(int key) {
		SLink previous, current;
		SLink newLink = new SLink(key);
		previous = null;
		current = first;

		while (current != null && key > current.data) {
			previous = current;
			current = current.next;
		}

		if (previous == null)
			first = newLink;
		else
			previous.next = newLink;
		newLink.next = current;
	}

	public SLink remove() {
		SLink temp;
		temp = first;
		first = first.next;
		return temp;
	}

	public void displayLink() {
		SLink current;
		current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
	}

}

public class sortedLinkListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SLinkList theList = new SLinkList();
		theList.insert(30);
		theList.insert(20);
		theList.insert(10);
		//theList.displayLink();
		theList.remove();
		theList.displayLink();

	}

}
