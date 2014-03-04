package com.pckg.java;

import java.util.*;

public class DuplicateWordSearcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "a r b k c d se f g a d f s s f d s ft gh f ws w f v x s g h d h j j k f sd j e wed a d f";

		/*
		 * List<String> list = Arrays.asList(text.split(" "));
		 * 
		 * Set<String> uniqueWords = new HashSet<String>(list); for (String word
		 * : uniqueWords) { System.out.println(word + ": " +
		 * Collections.frequency(list, word)); }
		 */

		List<String> list = Arrays.asList(text.split(" "));
		Set<String> uniqueWords = new HashSet<String>(list);
		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
		for (String word : uniqueWords) {
			wordCount.put(word, 0);
		}

		for (String w : list) {
			int i = wordCount.get(w);
			if (i == 0)
				wordCount.put(w, 1);
			else
				wordCount.put(w, i + 1);
		}

		for (String ww : wordCount.keySet()) {
			System.out.println(ww + ": " + wordCount.get(ww));
		}

	}

}
