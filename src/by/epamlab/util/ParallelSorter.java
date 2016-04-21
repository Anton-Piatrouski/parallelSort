package by.epamlab.util;
import java.util.Arrays;

import by.epamlab.util.ArraySorter;
import by.epamlab.util.ArrayUtil;

public class ParallelSorter {

	/*
	 * Divides the specified array into two parts and sorts them in different threads.
	 * Merges parts.
	 */
	public static int[] sort(int[] unsorted) throws InterruptedException {

		int length = unsorted.length;
		int middle = length / 2;
		
		int[] left = Arrays.copyOfRange(unsorted, 0, middle);
		int[] right = Arrays.copyOfRange(unsorted, middle, length);
		
		Thread sorter1 = new Thread(new ArraySorter(left));
		Thread sorter2 = new Thread(new ArraySorter(right));
		
		sorter1.start();
		Thread.sleep(250);
		sorter2.start();
		
		sorter1.join();
		sorter2.join();
		
		int[] sorted = ArrayUtil.merge(left, right);
		
		return sorted;
	}

}
