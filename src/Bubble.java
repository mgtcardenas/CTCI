/**
 * Simple implementation of the BubbleSort algorithm
 */
public class Bubble
{
	private static void printArray(int[] array)
	{
		for (int i = 0; i < array.length - 1; i++)
			System.out.print(array[i] + ", ");
		System.out.println(array[array.length - 1]);
	}// end printArrayPretty
	
	private static void bubbleSort(int[] arr)
	{
		for (int i = arr.length - 1; i > 0; i--)
			for (int j = 0; j < i; j++)
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
	}// end bubbleSort
	
	private static void swap(int[] arr, int i, int j)
	{
		int tmp = arr[i];
		arr[i]	= arr[j];
		arr[j]	= tmp;
	}// end swap
	
	public static void main(String[] args)
	{
		int[] arr = { 10, -5, 7, 6, 2 };
		bubbleSort(arr);
		printArray(arr);
	}// end main
}// end Bubble - class
