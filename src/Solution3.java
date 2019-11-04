import java.util.Scanner;

public class Solution3
{
	public static String solution(String T)
	{
		// Your solution goes here.
		char[] arr = T.toCharArray();
		
		if (arr[4] == '?')
			arr[4] = '9';
		if (arr[3] == '?')
			arr[3] = '5';
		
		if (arr[1] == '?')
		{
			if (arr[0] == '2')
				arr[1] = '3';
			else if (arr[0] == '1' || arr[0] == '0')
				arr[1] = '9';
		}// end if
		
		if (arr[0] == '?')
		{
			if ('4' <= arr[1] && arr[1] <= '9')
				arr[0] = '1';
			else if ('0' <= arr[1] && arr[1] <= '3')
				arr[0] = '2';
		}// end if
		
		if (arr[0] == '?' && arr[1] == '?')
		{
			arr[0]	= '2';
			arr[1]	= '3';
		}// end if
		
		return new String(arr);
	}// end solution
	
	public static void main(String[] args)
	{
		// Read from stdin, solve the problem, write answer to stdout.
		Scanner in = new Scanner(System.in);
		System.out.print(solution(in.next()));
	}// end main
}// end Solution - class