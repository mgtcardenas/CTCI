public class Stack
{
	private static class Node
	{
		private int		data;
		private Node	next;
		
		private Node(int data)
		{
			this.data = data;
		}// end Node - constructor
	}// end Node - class
	
	private Node top;
	
	public boolean isEmpty()
	{
		return top == null;
	}// end isEmpty
	
	public int peek()
	{
		return top.data;
	}// end peek
	
	public void push(int data)
	{
		Node node;
		node		= new Node(data);
		node.next	= top;
		top			= node;
	}// end push
	
	public int pop()
	{
		int data = top.data;
		top = top.next;
		return data;
	}// end pop
	
	public static void main(String[] args)
	{
		Stack s = new Stack();
		s.push(5);
		s.push(7);
		s.push(0);
		if (!s.isEmpty())
		{
			System.out.println("Peeking: " + s.peek());
			System.out.println("Popping: " + s.pop());
			System.out.println("Popping: " + s.pop());
			System.out.println("Popping: " + s.pop());
		}// end if
	}// end main
}// end Stack - class
