package com.pckg.java;

import java.io.File;
import java.io.FileNotFoundException;

public class fileSize {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
        System.out.println(file.length());
	}
}
