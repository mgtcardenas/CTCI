package quicksort;

/**
 * Class that implements the QuickSort algorithm according to the famous book
 * 'Introduction to Algorithms, 3rd Edition (The MIT Press)'
 */
public class ScholarQS
{
	/**
	 * It is important to note that in the book, it is stated that...
	 * "To sort an entire array A, the initial call is OUICKSORT(A, 1, A.length)"
	 * However this book treats arrays as if their first index is 1 and their
	 * length is their last index. Because of that 1 here means the position
	 * of the first element and A.length means the position of the last element
	 * 
	 * @param A - the array to be sorted
	 */
	private static void scholarQuickSort(int[] A)
	{
		scholarQuickSort(A, 0, A.length - 1);
	}// end scholarQuickSort
	
	private static void scholarQuickSort(int[] A, int p, int r)
	{
		if (p < r)
		{
			int q = scholarPartition(A, p, r);
			scholarQuickSort(A, p, q - 1);
			scholarQuickSort(A, q + 1, r);
		}// end if
	}// end scholarQuickSort
	
	private static int scholarPartition(int[] A, int p, int r)
	{
		int	x	= A[r];
		int	i	= p - 1;
		for (int j = p; j <= r - 1; j++)
			if (A[j] <= x)
			{
				i++;
				swap(A, i, j);
			}// end if
			
		swap(A, i + 1, r);
		return i + 1;
	}// end scholarPartition
	
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
		int[] A = { 7, 3, 10, 2, 1, 5, 4, 6, 9, 8 };
		scholarQuickSort(A);
		printArray(A);
	}// end main
}// end ScholarQS - class
