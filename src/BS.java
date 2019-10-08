/**
 * Class that implements the binary search algorithm as explained by
 * Gayle Laakmann McDowell in her YouTube video found here https://www.youtube.com/watch?v=P3YID7liBug
 */
public class BS
{
	private static boolean binarySearchRecursive(int[] array, int x)
	{
		return binarySearchRecursive(array, x, 0, array.length - 1);
	}// end binarySearchRecursive
	
	private static boolean binarySearchRecursive(int[] array, int x, int leftStart, int rightEnd)
	{
		if (leftStart > rightEnd)
			return false;
		
		int mid = leftStart + (rightEnd - leftStart) / 2; // use this instead to avoid overflow; equivalent to (leftStart + rightEnd) / 2
		if (array[mid] == x)
			return true;
		else if (x < array[mid])
			return binarySearchRecursive(array, x, leftStart, mid - 1);
		else
			return binarySearchRecursive(array, x, mid + 1, rightEnd);
	}// end binarySearchRecursive
	
	private static boolean binarySearchIterative(int[] array, int x)
	{
		int	leftStart	= 0;
		int	rightEnd	= array.length - 1;
		
		while (leftStart <= rightEnd)
		{
			int mid = leftStart + (rightEnd - leftStart) / 2; // use this instead to avoid overflow; equivalent to (leftStart + rightEnd) / 2
			if (array[mid] == x)
				return true;
			else if (x < array[mid])
				rightEnd = mid - 1;
			else
				leftStart = mid + 1;
		}// end while
		
		return false;
	}// end binarySearchIterative
	
	public static void main(String[] args)
	{
		int[] array = { 1, 2, 3, 4, 6, 8, 9, 10 };
		System.out.println(binarySearchRecursive(array, 0 )); // false
		System.out.println(binarySearchRecursive(array, 6 )); // true
		System.out.println(binarySearchIterative(array, 12)); // false
		System.out.println(binarySearchIterative(array, 8 )); // true
	}// end main
}// end BS - class