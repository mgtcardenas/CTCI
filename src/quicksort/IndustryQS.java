package quicksort;

/**
 * Class that implements the QuickSort algorithm according to Gayle Laakmann McDowell's
 * tutorial found here https://www.youtube.com/watch?v=SLauY6PpjW4
 */
public class IndustryQS
{
	private static void industryQuickSort(int[] array)
	{
		industryQuickSort(array, 0, array.length - 1);
	}// end industryQuickSort
	
	/**
	 * Note that this method receives the position of the last element, not the size
	 * of the array
	 * 
	 * @param array     - the array to be sorted
	 * @param leftStart - the position of the first element
	 * @param rightEnd  - the position of the last element
	 */
	private static void industryQuickSort(int[] array, int leftStart, int rightEnd)
	{
		if (leftStart >= rightEnd)
			return;
		int	pivot	= array[leftStart + (rightEnd - leftStart) / 2]; // avoid overflow; equivalent to (leftStart + rightEnd) / 2
		int	index	= industryPartition(array, leftStart, rightEnd, pivot);
		industryQuickSort(array, leftStart, index - 1);
		industryQuickSort(array, index, rightEnd);
	}// end industryQuickSort
	
	private static int industryPartition(int[] array, int leftStart, int rightEnd, int pivot)
	{
		while (leftStart <= rightEnd)
		{
			while (array[leftStart] < pivot)
				leftStart++;
			
			while (array[rightEnd] > pivot)
				rightEnd--;
			
			if (leftStart <= rightEnd)
				swap(array, leftStart++, rightEnd--);
		}// end while
		
		return leftStart;
	}// end industryPartition
	
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
		int[] array = { 7, 3, 10, 2, 1, 5, 4, 6, 9, 8 };
		industryQuickSort(array);
		printArray(array);
	}// end main
}// end IndustryQS - class
