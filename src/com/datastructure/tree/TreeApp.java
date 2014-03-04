package com.datastructure.tree;

class Queue {
	int front;
	int rear;
	NodeX queueArray[];
	final int size = 20;

	public Queue() {
		front = 0;
		rear = -1;
		queueArray = new NodeX[size];
	}

	public void insert(NodeX leftChild) {
		if (rear == size - 1)
			rear = -1;
		queueArray[++rear] = leftChild;
	}

	public NodeX remove() {
		NodeX temp = queueArray[front++];
		if (front == size)
			front = 0;
		return temp;
	}

	public boolean isEmpty() {
		return (front == rear + 1 || (front + size - 1 == rear));
	}
}

class NodeX {
	public int value;
	public NodeX leftChild;
	public NodeX rightChild;
}

class TreeX {
	private NodeX root;

	public TreeX() {
		root = null;
	}

	public void insert(int v) {
		NodeX newNode = new NodeX();
		newNode.value = v;

		if (root == null)
			root = newNode;
		else {
			NodeX current = root;
			NodeX parent = current;
			;
			while (current != null) {
				parent = current;
				if (v < current.value)
					current = current.leftChild;
				else
					current = current.rightChild;
			}
			if (v < parent.value)
				parent.leftChild = newNode;
			else
				parent.rightChild = newNode;
		}
	}

	public NodeX find(int key) {
		NodeX current = root;
		while (key != current.value) {
			if (key < current.value)
				current = current.leftChild;
			else
				current = current.rightChild;

			if (current == null)
				return null;
		}

		return current;
	}

	public boolean delete(int key) {
		NodeX current = root;
		NodeX parent = root;
		boolean isLeftChild = true;

		while (current.value != key) {
			parent = current;
			if (key < current.value) {
				current = current.leftChild;
				isLeftChild = true;
			} else {
				current = current.rightChild;
				isLeftChild = false;
			}
		}

		if (current.leftChild == null && current.rightChild == null) {
			if (isLeftChild)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		} else if (current.leftChild == null) {
			if (isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		} else if (current.rightChild == null) {
			if (isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.rightChild;
		} else {
			NodeX successor = getSuccessor(current);

			if (current == root)
				root = successor;
			else {
				if (isLeftChild)
					parent.leftChild = successor;
				else
					parent.rightChild = successor;
				successor.leftChild = current.leftChild;
			}

		}
		return true;
	}

	private NodeX getSuccessor(NodeX delNode) {
		// TODO Auto-generated method stub
		NodeX successorParent = delNode;
		NodeX successor = delNode;
		NodeX current = delNode.rightChild;

		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}

		if (successor != delNode.rightChild) {
			successor.rightChild = delNode.rightChild;
			successorParent.leftChild = successor.rightChild;
		}
		return successor;
	}

	public void traverse(String type) {
		NodeX current = root;
		if (type.equals("inOrder"))
			inOrder(current);
		else if (type.equals("preOrder"))
			preOrder(current);
		else if (type.equals("postOrder"))
			postOrder(current);
		else if (type.equals("levelOrder"))
			levelOrder(current);
	}

	private void levelOrder(NodeX current) {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		System.out.println(current.value);
		q.insert(current.leftChild);
		q.insert(current.rightChild);
		current = q.remove();
		while (!q.isEmpty()) {
			if (current.leftChild == null && current.rightChild == null){
				System.out.println(current.value);
			}
			else if (current.leftChild == null)
				q.insert(current.rightChild);
			else if (current.rightChild == null)
				q.insert(current.leftChild);
			else {
				q.insert(current.leftChild);
				q.insert(current.rightChild);
				System.out.println(current.value);
			}
			current = q.remove();
		}
		System.out.println(current.value);
	}

	public void inOrder(NodeX current) {
		if (current != null) {
			inOrder(current.leftChild);
			System.out.println(current.value);
			inOrder(current.rightChild);
		}
	}

	public void preOrder(NodeX current) {
		if (current != null) {
			System.out.println(current.value);
			preOrder(current.leftChild);
			preOrder(current.rightChild);
		}
	}

	public void postOrder(NodeX current) {
		if (current != null) {
			postOrder(current.leftChild);
			postOrder(current.rightChild);
			System.out.println(current.value);
		}
	}
}

public class TreeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeX tree = new TreeX();
		tree.insert(55);
		tree.insert(25);
		tree.insert(65);
		tree.insert(20);
		tree.insert(35);
		tree.insert(60);
		tree.insert(70);
		tree.traverse("levelOrder");

	}

}
