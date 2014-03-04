package com.datastructure.recursion;

public class Tower {

	static int nDisk = 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doTower(nDisk, 'A', 'B', 'C');

	}

	private static void doTower(int nTop, char S, char I, char D) {
		// TODO Auto-generated method stub
		if (nTop == 1)
			System.out.println("Movng Disk 1 from " + S + " to " + D);
		else {
			doTower(nTop - 1, S, D, I);
			System.out.println("Moving Disk " + nTop + " from " + S + " to "
					+ D);
			doTower(nTop - 1, I, S, D);
		}
	}

}
