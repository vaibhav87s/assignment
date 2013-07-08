package com.assignment;

import java.io.IOException;
import java.util.ArrayList;

import com.assignment.util.HopFileReader;

/**
 * Program which reads input from a file and returns existing path from start to
 * end of array.
 * 
 * @author svaibhav
 * 
 */
public class ArrayHopping {

	/**
	 * Processes input and calculates minimum hops path from input[0] to input[n]
	 * @param input
	 * @return path
	 */
	public ArrayList<Integer> processInput(ArrayList<Integer> input) {
		int size = input.size();
		ArrayList<Integer> minCost = new ArrayList<Integer>(size);
		ArrayList<Integer> predecessor = new ArrayList<Integer>(size);

		initializeArrays(size, minCost, predecessor);

		if (input.get(0) == 0)
			throw new UnsupportedOperationException("Failure");

		// Computing the helper arrays.
		int i = 0;
		while (i < size - 1) {
			int reachability = input.get(i);
			for (int j = i + 1; j < reachability + i + 1; j++) {

				// Check whether reachability is within size
				if (j < size) {
					minCost.set(j, minCost.get(i) + 1);
					predecessor.set(j, i);
				}
			}
			i += reachability;
		}

		// Printing the path
		ArrayList<Integer> path = getPath(predecessor);
		printPath(path);
		return path;
	}

	/**
	 * Initializes the @param minCost and @param predecessor to default values.
	 * @param size
	 * @param minCost
	 * @param predecessor
	 */
	private void initializeArrays(int size, ArrayList<Integer> minCost,
			ArrayList<Integer> predecessor) {
		// Initialize minCost to INT_MAX and predecessor to -1.
		for (int i = 0; i < size; i++) {
			minCost.add(Integer.MAX_VALUE);
			predecessor.add(Integer.MIN_VALUE);
		}

		// Initialize minCost[0] as 1.
		minCost.set(0, 1);
		predecessor.set(0, -1);
	}

	/**
	 * Prints the output path to standard console.
	 * @param path
	 */
	public void printPath(ArrayList<Integer> path) {
		for (int i = path.size() - 1; i >= 0; i--) {
			System.out.print(path.get(i) + " ");
		}
		System.out.println("out");
	}

	/**
	 * Reconstructs the path from the predecessor array
	 * @param predecessor
	 * @return
	 */
	public ArrayList<Integer> getPath(ArrayList<Integer> predecessor) {
		int size = predecessor.size();
		int i = predecessor.get(size - 1);
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(size - 1);
		while (i != -1) {
			path.add(i);
			i = predecessor.get(i);
		}
		return path;
	}

	/**
	 * Utility Method. Removing for improved code coverage. public void
	 * printArrays(ArrayList<Integer> input, ArrayList<Integer> minCost,
	 * ArrayList<Integer> predecessor) { int size = minCost.size();
	 * System.out.println("\nInput Matrix :"); for(int i=0; i< size; i++) {
	 * System.out.print(input.get(i) + " "); }
	 * System.out.println("\nMinCost Matrix :"); for(int i=0; i< size; i++) {
	 * System.out.print(minCost.get(i) + " "); }
	 * System.out.println("\nPredecessor Matrix"); for(int i=0; i< size; i++) {
	 * System.out.print(predecessor.get(i) + " "); } }
	 */

	/**
	 * Reads a file and provides the output path or throws error if it does not exist.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ArrayHopping arrayHopping = new ArrayHopping();
		arrayHopping.checkArgs(args);

		HopFileReader reader;
		reader = new HopFileReader(args[0]);
		ArrayList<Integer> input = reader.readFile();
		arrayHopping.processInput(input);
	}

	/**
	 * Prints error message and throws exception in case no file argument is provided.
	 * @throws IOException
	 */
	void printNoFileUsage() throws IOException {
		String helpMessage = "No arguments provided. 1 argument is required. <FileName>";
		System.err.println(helpMessage);
		throw new IOException(helpMessage);
	}

	/**
	 * Prints error message and throws exception if incorrect number of arguments are given.
	 * @throws IOException
	 */
	void printMultipleArgsUsage() throws IOException {
		String helpMessage = "Only 1 argument is required. <FileName>";
		System.err.println(helpMessage);
		throw new IOException(helpMessage);
	}

	/**
	 * Checks the input arguments user has provided.
	 * @param args
	 * @throws IOException
	 */
	void checkArgs(String args[]) throws IOException {
		if (args.length == 0) {
			printNoFileUsage();
		} else if (args.length > 1) {
			printMultipleArgsUsage();
		}
	}
}
