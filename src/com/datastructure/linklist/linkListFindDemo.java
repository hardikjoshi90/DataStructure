package com.datastructure.linklist;

class LinkL {
	public int iData;
	public Double dData;
	public LinkL next;

	public LinkL(int id, Double dd) {
		iData = id;
		dData = dd;
	}

	public void displayLink() {
		System.out.println("{" + iData + ", " + dData + "}");
	}
}

class LinkListD {
	LinkL first;

	public LinkListD() {
		first = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertFirst(int id, Double dd) {
		LinkL newLink = new LinkL(id, dd);
		newLink.next = first;
		first = newLink;
	}

	public LinkL deleteFirst() {
		LinkL temp = first;
		first = first.next;
		return temp;
	}

	public LinkL find(int key) {
		LinkL current = first;

		while (current.iData != key) {
			if (current.next == null)
				return null;
			else {
				current = current.next;
			}
		}

		return current;

	}

	public LinkL delete(int key) {
		LinkL previous = first;
		LinkL current = first;

		while (current.iData != key) {
			if (current.next == null)
				return null;
			else {
				previous = current;
				current = current.next;
			}
		}
		if (current == first)
			first = first.next;
		else
			previous.next = current.next;
		return current;

	}
	
	public void displayList(){
		System.out.println("List (first --> Last):");
		LinkL current = first;
		
		while(current!=null){
			current.displayLink();
			current = current.next;
		}
	}

}

public class linkListFindDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkListD theList = new LinkListD(); // make list
		theList.insertFirst(22, 2.99); // insert 4 items
		theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);
		theList.displayList(); // display list
		LinkL f = theList.find(44); // find item
		if( f != null)
		System.out.println("Found link with key " + f.iData);
		else
			System.out.println("Can’t find link");
		LinkL d = theList.delete(66); // delete item
		if( d != null )
		System.out.println("Deleted link with key " + d.iData);
		else
		System.out.println("Can’t delete link");
		theList.displayList();

	}

}
