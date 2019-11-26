/**
 * Class that implements the insertion sort sorting algorithm
 * accompanied by a simple function to print arrays in a pretty format
 */
public class Insertion
{
	private static void printArray(int[] array)
	{
		for (int i = 0; i < array.length - 1; i++)
			System.out.print(array[i] + ", ");
		System.out.println(array[array.length - 1]);
	}// end printArray
	
	private static void insertionSort(int[] array)
	{
		int i, j, tmp;
		
		i = 1;
		while (i < array.length)
		{
			j	= i - 1;
			tmp	= array[i];
			while (j >= 0 && tmp < array[j])
			{
				array[j + 1] = array[j];
				j--;
			}// end while
			
			array[j + 1] = tmp;
			
			i++;
		}// end while
	}// end insertionSort
	
	public static void main(String[] args)
	{
		int[] array = { -7, 5, 10, 0, -2, 3 };
		insertionSort(array);
		printArray(array);
	}// end main
}// end Insertion - class