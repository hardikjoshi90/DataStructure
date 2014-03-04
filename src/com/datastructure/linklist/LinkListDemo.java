package com.datastructure.linklist;

class Link {
	public int iData;
	public Double dData;
	public Link next;

	public Link(int id, Double dd) {
		iData = id;
		dData = dd;
	}

	public void displayLink() {
		System.out.println("{" + iData + ", " + dData + "}");
	}
}

class LinkList {
	private Link first;
	private Link last;

	public LinkList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {

		return (first == null);
	}

	public void insertFirst(int id, Double dd) {
		Link newLink = new Link(id, dd);
		if (isEmpty()) {
			last = newLink;
		}
		newLink.next = first;
		first = newLink;

	}

	public void insertLast(int id, Double dd) {
		Link newLink = new Link(id, dd);
		if (isEmpty()) {
			first = newLink;
		} else
			last.next = newLink;
		last = newLink;
	}

	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}
	

	public void displayLink() {
		Link current = first;
		System.out.println("(first --> last)");
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
	}
}

public class LinkListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList theLink = new LinkList();
		theLink.insertFirst(10, 80.5);
		theLink.insertFirst(20, 25.5);
		theLink.displayLink();

	}

}
