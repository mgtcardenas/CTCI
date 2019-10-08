/**
 * Class that implements the merge sort sorting algorithm as explained by
 * Gayle Laakmann McDowell in her YouTube video found here https://www.youtube.com/watch?v=KF2j-9iSf4Q
 * It is accompanied by a simple function to print arrays in a pretty format
 */
public class Merge
{
	private static void printArray(int[] array)
	{
		for (int i = 0; i < array.length - 1; i++)
			System.out.print(array[i] + ", ");
		System.out.println(array[array.length - 1]);
	}// end printArray
	
	private static void mergeSort(int[] array)
	{
		mergeSort(array, new int[array.length], 0, array.length - 1);
	}// end mergeSort
	
	private static void mergeSort(int[] array, int[] tmp, int leftStart, int rightEnd)
	{
		if (leftStart >= rightEnd)
			return;
		int mid = leftStart + (rightEnd - leftStart) / 2; // get the mid point without causing an overflow; equivalent to (leftStart + rightEnd) / 2
		mergeSort(array, tmp, leftStart, mid);
		mergeSort(array, tmp, mid + 1, rightEnd);
		mergeHalves(array, tmp, leftStart, rightEnd);
	}// end mergeSort
	
	private static void mergeHalves(int[] array, int[] tmp, int leftStart, int rightEnd)
	{
		int	leftEnd		= leftStart + (rightEnd - leftStart) / 2; // get the mid point without causing an overflow; equivalent to (leftStart + rightEnd) / 2
		int	rightStart	= leftEnd + 1;
		int	size		= rightEnd - leftStart + 1;
		
		int	leftIndex	= leftStart;
		int	rightIndex	= rightStart;
		int	tmpIndex	= leftStart;
		
		while (leftIndex <= leftEnd && rightIndex <= rightEnd)
			if (array[leftIndex] < array[rightIndex])
				tmp[tmpIndex++] = array[leftIndex++];
			else
				tmp[tmpIndex++] = array[rightIndex++];
		
		System.arraycopy(array, leftIndex, tmp, tmpIndex, leftEnd - leftIndex + 1);
		System.arraycopy(array, rightIndex, tmp, tmpIndex, rightEnd - rightIndex + 1);
		System.arraycopy(tmp, leftStart, array, leftStart, size);
	}// end mergeHalves
	
	public static void main(String[] args)
	{
		int[] array = { 7, 3, 10, 2, 1, 5, 4, 6, 9, 8 };
		mergeSort(array);
		printArray(array);
	}// end main
}// end Merge - class
