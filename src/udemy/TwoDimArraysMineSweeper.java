package udemy;

/**
 * NOTES: I should have iterated only through the bombs (-1), and not the whole array
 */
public class TwoDimArraysMineSweeper
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
		int[][] bombs1 = { { 0, 2 }, { 2, 0 } };
		System.out.println("BOMBS1:");
		printField(mineSweeper(bombs1, 3, 3));
		System.out.println();
		// mineSweeper(bombs1, 3, 3) should return:
		// [[0, 1, -1],
		// [1, 2, 1],
		// [-1, 1, 0]]
		
		int[][] bombs2 = { { 0, 0 }, { 0, 1 }, { 1, 2 } };
		System.out.println("BOMBS2:");
		printField(mineSweeper(bombs2, 3, 4));
		System.out.println();
		// mineSweeper(bombs2, 3, 4) should return:
		// [[-1, -1, 2, 1],
		// [2, 3, -1, 1],
		// [0, 1, 1, 1]]
		
		System.out.println("BOMBS3:");
		int[][] bombs3 = { { 1, 1 }, { 1, 2 }, { 2, 2 }, { 4, 3 } };
		printField(mineSweeper(bombs3, 5, 5));
		System.out.println();
		// mineSweeper(bombs3, 5, 5) should return:
		// [[1, 2, 2, 1, 0],
		// [1, -1, -1, 2, 0],
		// [1, 3, -1, 2, 0],
		// [0, 1, 2, 2, 1],
		// [0, 0, 1, -1, 1]]
	}// end main
	
	// Implement your solution below.
	public static int[][] mineSweeper(int[][] bombs, int numRows, int numCols)
	{
		int[][] field = new int[numRows][numCols];
		for (int i = 0; i < bombs.length; i++)
			field[bombs[i][0]][bombs[i][1]] = -1;
		
		markAdjacentBombs(field);
		
		return field;
	}// end mineSweeper
	
	private static void markAdjacentBombs(int[][] field)
	{
		for (int i = 0; i < field.length; i++)
			for (int j = 0; j < field[i].length; j++)
				if (field[i][j] != -1)
					for (int x = -1; x <= 1; x++)
						for (int y = -1; y <= 1; y++)
							if (isInBounds(i + x, field.length) && isInBounds(j + y, field[i].length) && field[i + x][j + y] == -1)
								field[i][j]++;
	}// end markAdjacentBombs
	
	private static boolean isInBounds(int index, int length)
	{
		return index >= 0 && index < length;
	}// end isInBounds
}// end TwoDimArraysMineSweeper - class
