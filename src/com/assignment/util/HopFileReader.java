package com.assignment.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HopFileReader {

	final String WHITESPACE = " ";
	String fileName;
	void printUsage() {
		String helpMessage = "Only 1 argument is required. <FileName>";
		System.err.println(helpMessage);
	}
	
	void printNonExistentFile() {
		String helpMessage = "<FileName> does not exist!";
		System.err.println(helpMessage);
	}
	
	void validateNumber(Integer i) {
		if(i < 0) {
			String message= "No negative numbers allowed!";
			System.err.println(message);
			throw new NumberFormatException(message);
		}
	}
	
	public HopFileReader(final String fileName) {
		this.fileName = fileName;
	}
	
	public ArrayList<Integer> readFile() throws NumberFormatException, IOException {
		ArrayList<Integer> input = new ArrayList<Integer>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			String[] elements = line.split(WHITESPACE);
			for(String element : elements) {
				Integer i = Integer.valueOf(element);
				validateNumber(i);
				input.add(i);
			}
		} catch(FileNotFoundException ex) {
			printNonExistentFile();
			throw ex;
		} catch(IOException ex) {
			printUsage();
			throw ex;
		}
		return input;
	}
}
