/**
 * A class that demonstrates the basic idea of dynamic programming
 * by implementing a function that calculates the fibonacci sequence
 * in three different ways: one with simple recursion, other with
 * memoization and finally with a bottom-up approach as explained
 * in this video https://www.youtube.com/watch?v=vYquumk4nWw
 */
public class Dynamic
{
	private static int fib(int n)
	{
		if (n == 1 || n == 2)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}// end fib
	
	private static int use_fib_memo(int n)
	{
		int[] memo = new int[n + 1];
		return fib_memo(n, memo);
	}// end use_fib_memo
	
	private static int fib_memo(int n, int[] memo)
	{
		if (memo[n] != 0)
			return memo[n];
		if (n == 1 || n == 2)
			return memo[n] = 1;
		else
			return memo[n] = fib_memo(n - 1, memo) + fib_memo(n - 2, memo);
	}// end fib_memo
	
	private static int fib_bottom_up(int n)
	{
		if (n == 1 || n == 2)
			return 1;
		else
		{
			int[] memo = new int[n + 1];
			memo[1] = memo[2] = 1;
			for (int i = 3; i < memo.length; i++)
				memo[i] = memo[i - 1] + memo[i - 2];
			return memo[n];
		}// end if - else
	}// end fib_bottom_up
	
	public static void main(String[] args)
	{
		int num = 7;
		System.out.println("Fib of " + num + " is " + fib(num));
		System.out.println("Fib Memo of " + num + " is " + use_fib_memo(num));
		System.out.println("Fib Bottom-Up of " + num + " is " + fib_bottom_up(num));
	}// end main
}// end Dynamic - class