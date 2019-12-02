package udemy;

import java.util.ArrayList;

public class ArraysCommonElements
{
	private static void printArray(Integer[] arr)
	{
		if (arr.length != 0)
		{
			System.out.print("[ ");
			for (int i = 0; i < arr.length - 1; i++)
				System.out.print(arr[i] + ", ");
			System.out.println(arr[arr.length - 1] + " ]");
		}
		else
			System.out.println("[ ]");
	}// end printArray
	
	public static void main(String[] args)
	{
		// NOTE: The following input values are used for testing your solution.
		
		int[]	array1A	= { 1, 3, 4, 6, 7, 9 };
		int[]	array2A	= { 1, 2, 4, 5, 9, 10 };
		// commonElements(array1A, array2A) should return [1, 4, 9] (an array).
		
		int[]	array1B	= { 1, 2, 9, 10, 11, 12 };
		int[]	array2B	= { 0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15 };
		// commonElements(array1B, array2B) should return [1, 2, 9, 10, 12] (an array).
		
		int[]	array1C	= { 0, 1, 2, 3, 4, 5 };
		int[]	array2C	= { 6, 7, 8, 9, 10, 11 };
		// common_elements(array1C, array2C) should return [] (an empty array).
		printArray(commonElements(array1A, array2A));
		printArray(commonElements(array1B, array2B));
		printArray(commonElements(array1C, array2C));
	}// end main
	
	// Implement your solution below.
	// NOTE: Remember to return an Integer array, not an int array.
	public static Integer[] commonElements(int[] array1, int[] array2)
	{
		ArrayList<Integer> tmp = new ArrayList<>();
		int                a, b, c;
		a	= 0;
		b	= 0;
		while (a < array1.length && b < array2.length)
		{
			if (array1[a] == array2[b])
			{
				tmp.add(array1[a]);
				a++;
				b++;
			}// end if
			else if (array1[a] < array2[b])
				a++;
			else
				b++;
		}// end while
		
		return tmp.toArray(new Integer[0]);
	}// end commonElements
}// end ArraysCommonElements - class
