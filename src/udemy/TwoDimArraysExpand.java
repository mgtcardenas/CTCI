package udemy;

public class TwoDimArraysExpand
{
	private static void printField(int[][] field)
	{
		for (int i = 0; i < field.length; i++)
		{
			for (int j = 0; j < field[i].length; j++)
				System.out.print(field[i][j] + " ");
			System.out.println();
		}// end for - i
	}// end printField
	
	public static void main(String[] args)
	{
		// NOTE: The following input values will be used for testing your solution.
		int[][] field1 = { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 0 }, { 0, 1, -1, 1, 0 } };
		System.out.println("FIELD 1 (1):");
		printField(click(field1, 3, 5, 2, 2));
		System.out.println();
		// click(field1, 3, 5, 2, 2) should return:
		// [[0, 0, 0, 0, 0],
		// [0, 1, 1, 1, 0],
		// [0, 1, -1, 1, 0]]
		
		System.out.println("FIELD 1 (2):");
		printField(click(field1, 3, 5, 1, 4));
		System.out.println();
		// click(field1, 3, 5, 1, 4) should return:
		// [[-2, -2, -2, -2, -2],
		// [-2, 1, 1, 1, -2],
		// [-2, 1, -1, 1, -2]]
		
		int[][] field2 = { { -1, 1, 0, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 }, { 0, 0, 1, -1 } };
		System.out.println("FIELD 2 (1):");
		printField(click(field2, 4, 4, 0, 1));
		System.out.println();
		// click(field2, 4, 4, 0, 1) should return:
		// [[-1, 1, 0, 0],
		// [1, 1, 0, 0],
		// [0, 0, 1, 1],
		// [0, 0, 1, -1]]
		
		System.out.println("FIELD 2 (2):");
		printField(click(field2, 4, 4, 1, 3));
		System.out.println();
		// click(field2, 4, 4, 1, 3) should return:
		// [[-1, 1, -2, -2],
		// [1, 1, -2, -2],
		// [-2, -2, 1, 1],
		// [-2, -2, 1, -1]]
	}// end main
	
	// Implement your solution below.
	public static int[][] click(int[][] field, int numRows, int numCols, int givenI, int givenJ)
	{
		if (field[givenI][givenJ] == 0)
			expandRecursive(field, numRows, numCols, givenI, givenJ);
		
		return field;
	}// end click
	
	private static void expandRecursive(int[][] field, int numRows, int numCols, int givenI, int givenJ)
	{
		field[givenI][givenJ] = -2;
		// look for adjacent valid places to call expand recursively
		for (int x = -1; x <= 1; x++)
			for (int y = -1; y <= 1; y++)
				if (inBounds(givenI + x, numRows) && inBounds(givenJ + y, numCols) && field[givenI + x][givenJ + y] == 0)
					expandRecursive(field, numRows, numCols, givenI + x, givenJ + y);
	}// end expandRecursive
	
	private static boolean inBounds(int index, int length)
	{
		return 0 <= index && index < length;
	}// end inBounds
}// end TwoDimArraysExpand - class
