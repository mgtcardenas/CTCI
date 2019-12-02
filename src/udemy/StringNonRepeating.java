package udemy;

import java.util.HashMap;
import java.util.HashSet;

public class StringNonRepeating
{
	public static void main(String[] args)
	{
		// NOTE: The following input values will be used for testing your solution.
		System.out.println(nonRepeating("abcab")); // should return 'c'
		System.out.println(nonRepeating("abab")); // should return null
		System.out.println(nonRepeating("aabbbc")); // should return 'c'
		System.out.println(nonRepeating("aabbdbc")); // should return 'd'
	}// end main
	
	// Implement your solution below.
	public static Character nonRepeating(String s)
	{
		HashMap<Character, Integer>	tally				= new HashMap<>();
		HashSet<Character>			nonRepeatingChars	= new HashSet<>();
		
		for (int i = 0; i < s.length(); i++)
			if (!tally.containsKey(s.charAt(i)))
				tally.put(s.charAt(i), 1);
			else
				tally.put(s.charAt(i), tally.get(s.charAt(i)) + 1);
			
		for (Character c : tally.keySet())
			if (tally.get(c) == 1)
				nonRepeatingChars.add(c);
			
		if (!nonRepeatingChars.isEmpty())
			for (int i = 0; i < s.length(); i++)
				if (nonRepeatingChars.contains(s.charAt(i)))
					return s.charAt(i);
				
		return null;
	}// end nonRepeating
}// end StringNonRepeating - class
