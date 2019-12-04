package udemy;

import java.util.LinkedList;

public class LLNthElement
{
	private static class Node
	{
		int		value;
		Node	child;
		
		Node(int value, Node child)
		{
			this.value	= value;
			this.child	= child;
		}// end Node - class
		
		// The string representation of this node.
		// Will be used for testing.
		@Override
		public String toString()
		{
			return String.valueOf(value);
		}// end toString
	}// end Node - class
	
	public static void main(String[] args)
	{
		// NOTE: The following input values will be used for testing your solution.
		Node current = new Node(1, null);
		for (int i = 2; i < 8; i++)
			current = new Node(i, current);
		Node	head		= current;
		// head = 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)
		
		Node	current2	= new Node(4, null);
		for (int i = 3; i > 0; i--)
			current2 = new Node(i, current2);
		Node head2 = current2;
		// head2 = 1 -> 2 -> 3 -> 4 -> (null)
		
		// nthFromLast(head, 1) should return 1.
		System.out.println(nthFromLast(head, 1).value);
		// nthFromLast(head, 5) should return 5.
		System.out.println(nthFromLast(head, 5).value);
		// nthFromLast(head2, 2) should return 3.
		System.out.println(nthFromLast(head2, 2).value);
		// nthFromLast(head2, 4) should return 1.
		System.out.println(nthFromLast(head2, 4).value);
		// nthFromLast(head2, 5) should return null.
		System.out.println(nthFromLast(head2, 5).value); // will cause null pointer exception
		// nthFromLast(null, 1) should return null.
		System.out.println(nthFromLast(null, 1).value); // will cause null pointer exception
	}
	
	// Implement your function below.
	public static Node nthFromLast(Node head, int n)
	{
		if (head == null)
			return null;
		
		LinkedList<Node>	ll	= new LinkedList<>();
		Node				tmp	= new Node(-1, head);
		while (tmp.child != null)
		{
			if (ll.size() == n)
				ll.remove();
			ll.add(tmp.child);
			tmp = tmp.child;
		}// end while
		
		if (ll.size() == n)
			return ll.remove();
		else
			return null;
	}// end nthFromLast
	
	// NOTE: Feel free to use the following function for testing.
	// It converts the given linked list into an easy-to-read string format.
	// Example: 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)
	public static String linkedListToString(Node head)
	{
		Node			current	= head;
		StringBuilder	sb		= new StringBuilder();
		while (current != null)
		{
			sb.append(String.valueOf(current.value));
			sb.append(" -> ");
			current = current.child;
		}
		sb.append("(null)");
		return sb.toString();
	}
}// end LLNthElement - class
