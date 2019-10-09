package quicksort;

public class ScholarQS
{
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
		printArray(array);
	}// end main
}// end ScholarQS - class
