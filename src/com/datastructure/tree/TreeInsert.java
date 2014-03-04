package com.datastructure.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
	public int idata;
	public Node leftChild;
	public Node rightChild;

	public void displayNode() {
		System.out.print("{");
		System.out.print(idata);
		System.out.print("} ");
		System.out.println();

	}
}

class Tree {
	private Node root;

	public Tree() {
		root = null;
	}

	public void insert(int data) {
		Node newNode = new Node();
		newNode.idata = data;
		if (root == null)
			root = newNode;
		else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;

				if (data < current.idata) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public Node find(int data) {
		Node current = root;
		if (root != null) {
			current = root;
			while (true) {
				if (current.idata < data)
					current = current.leftChild;
				else
					current = current.rightChild;
				if (current == null)
					return null;
			}
		}
		return current;
	}

	public boolean delete(int key) {
		Node parent = root;
		Node current = root;
		boolean isLeftChild = true;

		while (current.idata != key) {
			parent = current;
			if (key < current.idata) {
				current = current.leftChild;
				isLeftChild = true;
			} else {
				current = current.rightChild;
				isLeftChild = false;
			}
			if (current == null)
				return false;
		}

		if (current.leftChild == null && current.rightChild == null) {
			if (current == root)
				root = null;
			else if (isLeftChild)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}

		else if (current.leftChild == null) {
			if (current == root)
				root = current.rightChild;
			else if (isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		}

		else if (current.rightChild == null) {
			if (current == root)
				root = current.leftChild;
			else if (isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		}

		else {
			Node successor = getSuccessor(current);
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			successor.leftChild = current.leftChild;
		}
		return true;
	}

	private Node getSuccessor(Node delNode) {
		// TODO Auto-generated method stub
		Node parentSuccessor = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;

		while (current != null) {
			parentSuccessor = successor;
			successor = current;
			current = current.leftChild;
		}
		
		if(successor != delNode.rightChild){
			parentSuccessor.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}

		return successor;
	}

	public void traverse(int traverseType) {
		switch (traverseType) {
		case 1:
			inOrder(root);
			break;
		case 2:
			preOrder(root);
			break;
		case 3:
			postOrder(root);
			break;
		}
		System.out.println();

	}

	public void inOrder(Node localRoot) {

		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.println(localRoot.idata);
			inOrder(localRoot.rightChild);
		}
	}

	public void preOrder(Node localRoot) {

		if (localRoot != null) {

			System.out.println(localRoot.idata);
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	public void postOrder(Node localRoot) {

		if (localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.println(localRoot.idata);

		}

	}

}

public class TreeInsert {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Tree tree = new Tree();
		tree.insert(55);
		tree.insert(25);
		tree.insert(65);
		tree.insert(60);
		tree.insert(75);
		tree.insert(70);
		tree.insert(80);
		
		System.out.println("Enter your Choice for Traversing the Tree:");
		System.out.println("1. InOrder");
		System.out.println("2. PreOrder");
		System.out.println("3. PostOrder");

		int choice = getChoice();

		tree.traverse(choice);
		
		tree.delete(65);
		
		System.out.println("Enter your Choice for Traversing the Tree:");
		System.out.println("1. InOrder");
		System.out.println("2. PreOrder");
		System.out.println("3. PostOrder");

		int choice1 = getChoice();

		tree.traverse(choice1);

	}

	private static int getChoice() throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String str = br.readLine();

		return Integer.parseInt(str);
	}

}
