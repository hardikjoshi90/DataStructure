package com.datastructure.linklist;

class dLink {
	int data;
	dLink previous;
	dLink next;

	public dLink(int d) {
		data = d;
	}
}

class dLinkList {

	dLink first, last;

	public dLinkList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(int key) {
		dLink newLink = new dLink(key);

		if (isEmpty())
			last = newLink;
		else {
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink;

	}

	public void insertLast(int key) {
		dLink newLink = new dLink(key);

		if (isEmpty())
			first = newLink;
		else {
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
	}

	public void insertAfter(int data, int key) {
		dLink current;
		current = first;

		while (current.data != data)
			current = current.next;
		if (current != null) {
			dLink newLink = new dLink(key);
			if (current == last) {
				newLink.next = null;
				last = newLink;

			} else {
				newLink.next = current.next;
				current.next.previous = newLink;
			}
			newLink.previous = current;
			current.next = newLink;
		} else
			System.out.println("Can't find the key:" + key);
	}

	public dLink removeFirst() {
		dLink temp;
		temp = first;

		if (first.next == null)
			last = null;
		else
			first.next.previous = null;
		first = first.next;

		return temp;
	}

	public dLink removeLast() {
		dLink temp;
		temp = last;
		if (last.previous == null)
			first = null;
		else {
			last.previous.next = null;
		}
		last = last.previous;
		return temp;
	}

	public dLink removeKey(int key) {
		dLink current;
		current = first;

		while (current.data != key)
			current = current.next;
		if (current == first)
			first = first.next;
		else
			current.previous.next = current.next;
		if (current == last)
			last.previous = current;
		current.next.previous = current.previous;
		return current;
	}

	public void displayForward() {
		dLink current;
		current = first;
		System.out.println("Displaying forward");
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	public void displayBackward() {
		dLink current;
		current = last;
		System.out.println("Displaying Backword");
		while (current != null) {
			System.out.println(current.data);
			current = current.previous;
		}
	}
}

public class DoublyLinkListDemo {

	public static void main(String[] args) {
		dLinkList theList = new dLinkList();// TODO Auto-generated method stub
		theList.insertFirst(22); // insert at front
		theList.insertFirst(44);
		theList.insertFirst(66);
		theList.insertLast(11); // insert at rear
		theList.insertLast(33);
		theList.insertLast(55);
		theList.displayForward(); // display list forward
		theList.displayBackward(); // display list backward
		theList.removeFirst(); // delete first item
		theList.removeLast(); // delete last item
		theList.removeKey(11); // delete item with key 11
		theList.displayForward(); // display list forward
		theList.insertAfter(22, 77); // insert 77 after 22
		theList.insertAfter(33, 88); // insert 88 after 33
		theList.displayForward(); //
	}

}
