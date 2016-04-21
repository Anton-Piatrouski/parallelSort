package by.epamlab.util;

public class ArrayUtil {

	/*
	 * Merges two sorted parts of the array
	 */
	public static int[] merge(int[] left, int[] right) {
		int indexLeft = 0, indexRight = 0, index = 0;
		int sizeLeft = left.length;
		int sizeRight = right.length;
		int[] merged = new int[sizeLeft + sizeRight];
		
		while (indexLeft < sizeLeft && indexRight < sizeRight) {
			
			if (left[indexLeft] <= right[indexRight]) {
				merged[index] = left[indexLeft];
				indexLeft++;
			} else {
				merged[index] = right[indexRight];
				indexRight++;
			}
			index++;
		}
		
		int elementsToBeCopied = merged.length - index;
		
		if (indexLeft < sizeLeft) {
			System.arraycopy(left, indexLeft, merged, index, elementsToBeCopied);
		}
		if (indexRight < sizeRight) {
			System.arraycopy(right, indexRight, merged, index, elementsToBeCopied);
		}
		
		return merged;
	}
	
}
