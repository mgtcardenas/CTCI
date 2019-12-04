package udemy;

/**
 * I should have modularized the solution
 */
public class StringOneAway
{
	public static void main(String[] args)
	{
		// NOTE: The following input values will be used for testing your solution.
		System.out.println(isOneAway("abcde", "abcd")); // should return true
		System.out.println(isOneAway("abde", "abcde")); // should return true
		System.out.println(isOneAway("a", "a")); // should return true
		System.out.println(isOneAway("abcdef", "abqdef")); // should return true
		System.out.println(isOneAway("abcdef", "abccef"));  // should return true
		System.out.println(isOneAway("abcdef", "abcde")); // should return true
		System.out.println(isOneAway("aaa", "abc")); // should return false
		System.out.println(isOneAway("abcde", "abc")); // should return false
		System.out.println(isOneAway("abc", "abcde")); // should return false
		System.out.println(isOneAway("abc", "bcc")); // should return false
	}// end main
	
	// Implement your solution below.
	public static Boolean isOneAway(String s1, String s2)
	{
		int	diffChars	= 0;
		int	a			= 0;
		int	b			= 0;
		
		if (s1.length() == s2.length())
		{
			while (a < s1.length() && b < s2.length())
			{
				if (s1.charAt(a) == s2.charAt(b))
				{
					a++;
					b++;
				}
				else
				{
					diffChars++;
					a++;
					b++;
				}// end if - else
				
				if (diffChars >= 2)
					return false;
			}// end while
			
			return true;
		}
		else if (Math.abs(s1.length() - s2.length()) == 1)
		{
			String	longString	= s1.length() - s2.length() == 1 ? s1 : s2;
			String	shortString	= s1.length() - s2.length() == -1 ? s1 : s2;
			
			while (a < longString.length() && b < shortString.length())
			{
				if (longString.charAt(a) == shortString.charAt(b))
				{
					a++;
					b++;
				}
				else
				{
					diffChars++;
					a++;
				}// end if - else
				
				if (diffChars >= 2)
					return false;
			}// end while
			
			return true;
		}// end if - else
		
		return false;
	}// end isOneAway
}// end StringOneAway - class
