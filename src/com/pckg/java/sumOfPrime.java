package com.pckg.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class sumOfPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = sumOfPrime();
		System.out.println(ans);
	}

	private static int sumOfPrime() {
		// TODO Auto-generated method stub
		Set<Integer> prime = new HashSet<Integer>();
		HashMap<String, Integer> biggest = new HashMap<String, Integer>();
		biggest.put("sum", 0);
		int count = 0;
		for (int i = 2; i < 8000; i++) {
			for (int j = 1; j <= i; j++) {
				if (i % j == 0)
					count = count + 1;
			}
			if (count == 2)
				prime.add(i);
			count = 0;
			if(prime.size()==1000)
				break;
		}
		for (Integer p : prime) {
			biggest.put("sum", biggest.get("sum") + p);
		}

		return biggest.get("sum");
	}
}
