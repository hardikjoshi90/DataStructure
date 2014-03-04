package com.paclage.graph;

import java.util.Stack;
import com.paclage.*;

class QueueX {
	int front;
	int rear;
	int queueArray[];
	final int size = 20;

	public QueueX() {
		front = 0;
		rear = -1;
		queueArray = new int[size];
	}

	public void insert(int n) {
		if (rear == size - 1)
			rear = -1;
		queueArray[++rear] = n;
	}

	public int remove() {
		int temp = queueArray[front++];
		if (front == size)
			front = 0;
		return temp;
	}

	public boolean isEmpty() {
		return (front == rear + 1 || (front + size - 1 == rear));
	}
}

class vrtx {
	char label;
	boolean wasVisited;

	public vrtx(char lbl) {
		label = lbl;
		wasVisited = false;
	}
}

class graph {

	int nVerts;
	vrtx[] vertexList;
	int[][] adjMatrix;
	final int MAX_VERTS;

	public graph() {
		MAX_VERTS = 20;
		vertexList = new vrtx[MAX_VERTS];
		adjMatrix = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;

		for (int i = 0; i < MAX_VERTS; i++)
			for (int j = 0; j < MAX_VERTS; j++)
				adjMatrix[i][j] = 0;
	}

	public void addVertex(char label) {
		vertexList[nVerts++] = new vrtx(label);
	}

	public void addEdge(char start, char end) {
		int i = getEdgeStart(start);
		int j = getEdgeEnd(end);
		adjMatrix[i][j] = 1;
		// adjMatrix[j][i] = 1;
	}

	public void displayVertex(int n) {
		System.out.print(vertexList[n].label + " ");
	}

	private int getEdgeEnd(char end) {
		// TODO Auto-generated method stub
		int e = 0;
		for (int i = 0; i < nVerts; i++) {
			if (vertexList[i].label == end) {
				e = i;
				break;
			}
		}
		return e;
	}

	private int getEdgeStart(char start) {
		// TODO Auto-generated method stub
		int s = 0;
		for (int i = 0; i < nVerts; i++) {
			if (vertexList[i].label == start) {
				s = i;
				break;
			}
		}
		return s;
	}

	public void DFS() {
		vertexList[0].wasVisited = true;
		displayVertex(0);
		Stack<Integer> theStack = new Stack<Integer>();
		theStack.push(0);
		while (!theStack.isEmpty()) {
			int v = getAdjVertex(theStack.peek());

			if (v == -1)
				theStack.pop();
			else {
				vertexList[v].wasVisited = true;
				displayVertex(v);
				theStack.push(v);
			}
		}
		for (int j = 0; j < nVerts; j++)
			vertexList[j].wasVisited = false;
	}

	public void BFS() {

		QueueX theQueue = new QueueX();
		vertexList[0].wasVisited = true;
		displayVertex(0);
		theQueue.insert(0);
		int v = 0;

		while (!theQueue.isEmpty()) {

			int current = theQueue.remove();

			while ((v = getAdjVertex(current)) != -1) {
				vertexList[v].wasVisited = true;
				displayVertex(v);
				theQueue.insert(v);
			}
		}
		for (int j = 0; j < nVerts; j++)
			vertexList[j].wasVisited = false;
	}

	private int getAdjVertex(int v) {
		// TODO Auto-generated method stub
		for (int j = 0; j < MAX_VERTS; j++)
			if (adjMatrix[v][j] == 1 && vertexList[j].wasVisited == false)
				return j;
		return -1;
	}

	public void warShall() {
		// TODO Auto-generated method stub
		for (int i = 0; i < nVerts; i++)
			for (int j = 0; j < nVerts; j++)
				if (adjMatrix[i][j] == 1) {
					for (int k = 0; k < nVerts; k++)
						if (adjMatrix[k][i] == 1)
							adjMatrix[k][j] = 1;
				}
		for (int i = 0; i < nVerts; i++) {
			for (int j = 0; j < nVerts; j++) {
				System.out.print(adjMatrix[i][j] + "  ");
			}
			System.out.println();
		}
	}
}

public class GraphApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		graph theGraph = new graph();
		theGraph.addVertex('A'); // 0
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4

		theGraph.addEdge('A', 'B');
		theGraph.addEdge('B', 'C');
		theGraph.addEdge('B', 'D');
		theGraph.addEdge('A', 'D');
		theGraph.addEdge('D', 'E');
		System.out.println("BFS VISITS:");
		theGraph.BFS();
		System.out.println("\n\nDFS VISITS:");
		theGraph.DFS();

	}

}
