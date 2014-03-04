package com.paclage.graph;

class Queue {
	int front;
	int rear;
	int queueArray[];
	final int size = 20;

	public Queue() {
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

class VertexX {
	char label;
	boolean wasVisited;

	public VertexX(char lab) {
		label = lab;
		wasVisited = false;
	}
}

class GraphX {
	final int MAX_VERTS = 20;
	VertexX vertexList[];
	int adj[][];
	int nVertex;
	Queue theQueue;

	public GraphX() {
		vertexList = new VertexX[MAX_VERTS];
		adj = new int[MAX_VERTS][MAX_VERTS];
		nVertex = 0;
		for (int j = 0; j < MAX_VERTS; j++)
			for (int k = 0; k < nVertex; k++)
				adj[j][k] = 0;
		theQueue = new Queue();
	}

	public void addVertex(char lab) {
		vertexList[nVertex++] = new VertexX(lab);
	}

	public void addEdge(int start, int end) {
		adj[start][end] = 1;
		adj[end][start] = 1;
	}

	public void displayVertex(int v) {
		System.out.println(vertexList[v].label);
	}

	public void bfs() {
		vertexList[0].wasVisited = true;
		displayVertex(0);
		theQueue.insert(0);
		int v2;

		while (!theQueue.isEmpty()) {
			int v1 = theQueue.remove();

			while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				theQueue.insert(v2);
			}
		}

		for (int j = 0; j < nVertex; j++)
			vertexList[j].wasVisited = false;
	}

	private int getAdjUnvisitedVertex(int v1) {
		// TODO Auto-generated method stub
		for (int j = 0; j < nVertex; j++)
			if (adj[v1][j] == 1 && vertexList[j].wasVisited == false)
				return j;
		return -1;
	}
}

public class BFSApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphX theGraph = new GraphX();
		theGraph.addVertex('A'); // 0
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4
		theGraph.addEdge(0, 1); // AB
		theGraph.addEdge(1, 2); // BC
		theGraph.addEdge(0, 3); // AD
		theGraph.addEdge(3, 4); // DE
		System.out.print("Visits: ");
		theGraph.bfs();
		System.out.println();

	}

}
