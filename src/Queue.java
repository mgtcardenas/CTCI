public class Queue
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
	
	private Node	head; // remove from the head
	private Node	tail; // add things here
	
	public boolean isEmpty()
	{
		return head == null;
	}// end isEmpty
	
	public int peek()
	{
		return head.data;
	}// end peek
	
	public void add(int data)
	{
		Node node = new Node(data);
		if (tail != null)
			tail.next = node;
		tail = node;
		if (head == null)
			head = node;
	}// end add
	
	public int remove()
	{
		int data = head.data;
		head = head.next;
		if (head == null)
			tail = null;
		return data;
	}// end remove
	
	public static void main(String[] args)
	{
		Queue q = new Queue();
		q.add(5);
		q.add(7);
		q.add(0);
		if (!q.isEmpty())
		{
			System.out.println("Peeking: " + q.peek());
			System.out.println("Removing: " + q.remove());
			System.out.println("Removing: " + q.remove());
			System.out.println("Removing: " + q.remove());
		}// end if
	}// end main
}// end Queue - class
