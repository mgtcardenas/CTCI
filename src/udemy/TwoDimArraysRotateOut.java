package udemy;

public class TwoDimArraysRotateOut
{
	private static void printArray(int[][] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}// end for - i
	}// end printArray
	
	public static void main(String[] args)
	{
		// NOTE: The following input values will be used for testing your solution.
		int a1[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printArray(rotate(a1, 3));
		// rotate(a1, 3) should return:
		// [[7, 4, 1],
		// [8, 5, 2],
		// [9, 6, 3]]
		
		int a2[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printArray(rotate(a2, 4));
		// rotate(a2, 4) should return:
		// [[13, 9, 5, 1],
		// [14, 10, 6, 2],
		// [15, 11, 7, 3],
		// [16, 12, 8, 4]]
	}
	
	// Implement your solution below.
	public static int[][] rotate(int[][] a, int n)
	{
		// NOTE: To solve it in place, write this function so that you
		// won't have to create rotated.
		int[][]	rotated	= new int[n][n];
		
		int[]	coords;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
			{
				coords							= getNewCoords(i, j, n);
				rotated[coords[0]][coords[1]]	= a[i][j];
			}// end for - j
			
		return rotated;
	}// end rotate
	
	private static int[] getNewCoords(int i, int j, int n)
	{
		return new int[] { j, n - i - 1 };
	}// end getNewCoords
}// end TwoDimArraysRotateOut - class
