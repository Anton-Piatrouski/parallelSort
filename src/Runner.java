import java.util.Random;

import by.epamlab.util.ParallelSorter;

public class Runner {

	private static final int LENGTH = 1000;
	
	public static void main(String[] args) {

		// Create new unsorted array
		int[] unsorted = new int[LENGTH];
		
		// Fill the array with random integers
		for (int i = 0; i < LENGTH; i++) {
			unsorted[i] = getRandomNumber();
		}
		
		try {
			// Sort the specified array in parallel
			int[] sorted = ParallelSorter.sort(unsorted);
			
			for (int x : sorted) {
				System.out.println(x);
			}
		} catch (InterruptedException ignore) {
			/*NOP*/
		}
	}
	
	/*
	 * Generates random integers in range
	 */
	private static int getRandomNumber() {
		int min = 1, max = LENGTH - 1;
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
