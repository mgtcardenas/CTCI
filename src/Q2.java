import java.util.Scanner;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class Solution
{
	static Integer[] solution(Integer[] N, int K)
	{
		// Your solution goes here.
		
		Integer[]	biggest	= new Integer[K];
		Integer[]	tmp		= new Integer[K];
		
		for (int i = 0; i < K; i++)
			biggest[i] = N[i];
		
		for (int i = 1; (i + K) <= N.length; i++)
		{
			for (int j = i, h = 0; j < (i + K); j++, h++)
			{
				tmp[h] = N[j];
				System.out.print(N[j] + "-h:" + (j - i) + " ");
			}// end for - j
			
			biggest = getBiggest(biggest, tmp);
			System.out.println();
		}// end for - i
		
		return biggest;
	}// end solution
	
	static Integer[] getBiggest(Integer[] x, Integer[] y)
	{
		for (int i = 0; i < x.length; i++)
			if (x[i] > y[i])
				return x;
			else if (x[i] < y[i])
				return y;
			
		return x;
	}// end getBiggest
	
	public static void main(String[] args)
	{
		Scanner		in	= new Scanner(System.in);
		Integer[]	N	= getIntegerArray(in.next());
		Integer		K	= Integer.parseInt(in.next());
		System.out.print(fromIntArray(solution(N, K)));
		
		// TODO: Delete this after finishing, but good job
		/*
		 * int[] a = { 1, 2, 4, 3, 5 };
		 * int[] b = { 1, 2, 3, 4, 5 };
		 * 
		 * for (int i : getBiggest(a, b))
		 * System.out.print(i + " ");
		 */
	}// end main
	
	private static Integer[] getIntegerArray(String str)
	{
		return Stream.of(str.split("\\,")).map(Integer::valueOf).toArray(Integer[]::new);
	}// end getIntegerArray
	
	private static String fromIntArray(Integer[] input)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length; i++)
		{
			sb.append(input[i]);
			if (i < input.length - 1)
				sb.append(',');
		}// end for - i
		return sb.toString();
	}// end fromIntArray
}// end Solution - class
