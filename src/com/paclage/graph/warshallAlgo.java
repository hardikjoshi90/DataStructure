package com.paclage.graph;

public class warshallAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		graph theGraph = new graph();
		theGraph.addVertex('A'); // 0
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4
		
		theGraph.addEdge('A', 'C');
		theGraph.addEdge('B', 'A');
		theGraph.addEdge('B', 'E');
		theGraph.addEdge('E', 'C');
		theGraph.addEdge('D', 'E');
		
		theGraph.warShall();		
	}
}