package google;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

class Solution2
{
	static int solution(Integer[] loads)
	{
		int	s1; // the sum of the load of server 1
		int	s2; // the sum of the load of server 2
		
		s1	= 0;
		s2	= 0;
		
		Arrays.sort(loads);
		
		for (int i = loads.length - 1; i >= 0; i--)
			if (Math.abs((s1 + loads[i]) - s2) < Math.abs(s1 - (s2 + loads[i])))
				s1 += loads[i];
			else
				s2 += loads[i];
			
		return Math.abs(s1 - s2);
	}// end solution
	
	public static void main(String[] args)
	{
		Scanner		in		= new Scanner(System.in);
		Integer[]	loads	= getIntegerArray(in.next());
		
		System.out.print(solution(loads));
	}// end main
	
	private static Integer[] getIntegerArray(String str)
	{
		return Stream.of(str.split("\\,")).map(Integer::valueOf).toArray(Integer[]::new);
	}// end getIntegerArray
}// end Solution2