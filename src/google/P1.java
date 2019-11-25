package google;

import java.util.Scanner;
import java.util.stream.Stream;

class Solution1
{
	static int solution(Integer[] A)
	{
		int		numRows;
		int[]	lowest; // the last elements of each row
		boolean	assigned;
		
		numRows		= 1; // Given a non-empty array, there will always be at least one row
		lowest		= new int[A.length]; // at most there will be N rows
		lowest[0]	= A[0]; // At the beginning, the first element is the lowest of the first row
		
		for (int i = 1; i < A.length; i++)
		{
			assigned = false;
			
			for (int j = 0; j < numRows && !assigned; j++)
				if (A[i] < lowest[j])
				{
					lowest[j]	= A[i];
					assigned	= true;
				}// end if
				
			if (!assigned)
				lowest[numRows++] = A[i];
		}// end for - i
		
		return numRows;
	}// end solution
	
	public static void main(String[] args)
	{
		// Read from stdin, solve the problem, write answer to stdout.
		Scanner		in	= new Scanner(System.in);
		Integer[]	A	= getIntegerArray(in.next());
		
		System.out.print(solution(A));
	}// end main
	
	private static Integer[] getIntegerArray(String str)
	{
		return Stream.of(str.split("\\,")).map(Integer::valueOf).toArray(Integer[]::new);
	}// end getIntegerArray
}// end Solution - class