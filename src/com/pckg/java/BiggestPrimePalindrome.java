package com.pckg.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BiggestPrimePalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = biggestPrimePalindrome(1000);
		System.out.println(ans);

	}

	private static int biggestPrimePalindrome(int n) {
		// TODO Auto-generated method stub
		Set<String> prime = new HashSet<String>();
		HashMap<String, Integer> biggest = new HashMap<String, Integer>();
		biggest.put("prime", 0);
		int count=0;
		for(int i=2;i<n;i++){
			for(int j=1;j<=i;j++){
				if(i%j==0)
					count=count+1;
			}
			if(count==2)
				prime.add(Integer.toString(i));
			count=0;
		}
		for(String p:prime){
			 StringBuffer str = new StringBuffer(p);
			 String revStr = str.reverse().toString(); 
			 
			 
			if(p.equals(revStr) && Integer.parseInt(p) > biggest.get("prime")){
				biggest.put("prime", Integer.parseInt(p));
			}
				
		}
		
		return biggest.get("prime");
	}

}
