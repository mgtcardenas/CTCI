package quicksort;

/**
 * Class that implements the QuickSort algorithm according to Abdul Bari's
 * great tutorial found here https://www.youtube.com/watch?v=7h1s2SojIRw
 * The same algorithm can be implemented passing the array as an argument, but
 * here I try to remain as close as possible as the tutorial's code
 */
public class IndianQS
{
	private static int[] A = { 7, 3, 10, 2, 1, 5, 4, 6, 9, 8 };
	
	/**
	 * It is important to give as argument the length of the array (i.e. the number of elements),
	 * as opposed to other QuickSort algorithms where you must give the position of the last element
	 * 
	 * @param l - the position of the first element
	 * @param h - the number of elements
	 */
	private static void indianQuickSort(int l, int h)
	{
		if (l < h)
		{
			int j = indianPartition(l, h);
			indianQuickSort(l, j); // j must be passed because the right part is never taken into account when sorting
			indianQuickSort(j + 1, h); // j + 1 must be passed because the left part is actually taken into account when sorting
		}// end if
	}// end indianQuickSort
	
	/**
	 * One cannot change which pivot element was chosen and expect the algorithm
	 * to work. This partition is set up so that the first element is never taken
	 * into account and the last element is in fact taken into account. This last
	 * thing is why it was important to pass the length of the array as argument
	 * in the original call to indianQuickSort
	 * 
	 * @param  l - the position of the first element
	 * @param  h - the number of elements
	 * @return   the position which is already sorted (has the element that goes there)
	 */
	private static int indianPartition(int l, int h)
	{
		int	pivot	= A[l];
		int	i		= l;
		int	j		= h;
		
		while (i < j)
		{
			do // since we always increment at least once, we don't never compare the pivot
				i++;
			while (i < A.length - 1 && A[i] <= pivot); // end do-while, the index safety was not mentioned in the video
			
			do // since we always decrement at least once, we don't cause an array index out of bounds exception
				j--;
			while (j >= 0 && A[j] > pivot); // end do-while, the index safety was not mentioned in the video
			
			if (i < j)
				swap(A, i, j);
		}// end while
		
		swap(A, l, j);
		return j;
	}// end indianPartition
	
	private static void swap(int[] array, int i, int j)
	{
		int tmp;
		
		tmp			= array[i];
		array[i]	= array[j];
		array[j]	= tmp;
	}// end swap
	
	private static void printArray(int[] array)
	{
		for (int i = 0; i < array.length - 1; i++)
			System.out.print(array[i] + ", ");
		System.out.println(array[array.length - 1]);
	}// end printArray
	
	public static void main(String[] args)
	{
		indianQuickSort(0, A.length);
		printArray(A);
	}// end main
}// end IndianQS - class
