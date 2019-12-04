package udemy;

public class TwoDimArraysRotateIn
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
		int[]	tmp;
		int[]	coords;
		int		currentI;
		int		currentJ;
		
		for (int i = 0; i < n / 2; i++) // Math.ceil(n/2)
			for (int j = 0; j < n / 2 + n % 2; j++) // Math.floor(n/2)
			{
				tmp			= new int[4];
				currentI	= i;
				currentJ	= j;
				for (int k = 0; k < 4; k++)
				{
					tmp[k]		= a[currentI][currentJ];
					coords		= getNewCoords(currentI, currentJ, n);
					currentI	= coords[0];
					currentJ	= coords[1];
				}// end for - k
				for (int k = 0; k < 4; k++)
				{
					a[currentI][currentJ]	= tmp[(k + 3) % 4];
					coords					= getNewCoords(currentI, currentJ, n);
					currentI				= coords[0];
					currentJ				= coords[1];
				}// end for - k
			}// end for - j
			
		return a;
	}// end rotate
	
	private static int[] getNewCoords(int i, int j, int n)
	{
		return new int[] { j, n - i - 1 };
	}// end getNewCoords
}// end TwoDimArraysRotateIn - class
