package com.assignment;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

/**
 * List of unit tests for Array Hopping Class.
 * 
 * @author svaibhav
 *
 */
public class ArrayHoppingTest {

	ArrayHopping hopper = new ArrayHopping();
	
	@Test(expected=IOException.class)
	public void noFileGiven() throws IOException {
		String[] args = {};
		ArrayHopping.main(args);
	}
	
	@Test(expected=IOException.class)
	public void multipleInputArgs() throws IOException {
		String[] args = {"", ""};
		ArrayHopping.main(args);
	}
	
	@Test(expected=FileNotFoundException.class)
	public void nonExistentFile() throws IOException {
		String args[] = {"testInput/nonExistent"};
		ArrayHopping.main(args);
	}
	
	@Test(expected=NumberFormatException.class)
	public void negativeNumberFile() throws IOException {
		String args[] = {"testInput/negativeInput"};
		ArrayHopping.main(args);
	}
	
	@Test(expected=NumberFormatException.class)
	public void largeNumberFile() throws IOException {
		String args[] = {"testInput/largeInput"};
		ArrayHopping.main(args);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void unreachableInputFile() throws IOException {
		String args[] = {"testInput/unreachableInput"};
		ArrayHopping.main(args);
	}
	
	@Test
	public void happyCase() throws IOException {
		String args[] = {"testInput/input1"};
		ArrayHopping.main(args);
	}
	
	@Test
	public void happyCase2() throws IOException {
		String args[] = {"testInput/input2"};
		ArrayHopping.main(args);
	}
	
	@Test
	public void happyCase3() throws IOException {
		String args[] = {"testInput/input3"};
		ArrayHopping.main(args);
	}
}