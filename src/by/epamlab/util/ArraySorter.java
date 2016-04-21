package by.epamlab.util;

import java.util.Arrays;

public class ArraySorter implements Runnable {

	private int[] unsorted;
	
	public ArraySorter(int[] unsorted) {
		this.unsorted = unsorted;
	}
	
	@Override
	public void run() {
		Arrays.sort(unsorted);
	}

}
