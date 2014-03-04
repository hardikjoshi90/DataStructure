package com.datastructure.queue;

class pq {
	int maxSize;
	int[] queArray;
	int nItems;

	public pq(int s) {
		maxSize = s;
		queArray = new int[maxSize];
		nItems = 0;
	}

	public void insert(int i) {
		int j;
		if(nItems == 0){
			queArray[nItems++]=i;
		}
		else{
			for(j=nItems-1;j>=0;j--){
				if(i>queArray[j]){
					queArray[j+1]=queArray[j];
				}
				else
					break;
			}
			queArray[j+1]=i;
			nItems++;
		}
		
	}
	
	public int remove(){
		return queArray[--nItems];
	}
	
	public int peekMin(){
		return queArray[nItems-1];
	}
	
	public boolean isEmpty(){
		return (nItems==0);
	}
	
	public boolean isFull(){
		return (nItems==maxSize);
	}
	
}

public class PriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		pq thePQ = new pq(5);
		thePQ.insert(30);
		thePQ.insert(50);
		thePQ.insert(10);
		thePQ.insert(40);
		thePQ.insert(20);
		while( !thePQ.isEmpty() )
		{
		int item = thePQ.remove();
		System.out.print(item + " "); // 10, 20, 30, 40, 50
		} // end while
		System.out.println("");

	}

}
