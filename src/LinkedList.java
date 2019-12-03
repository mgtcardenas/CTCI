public class LinkedList
{
	class Node
	{
		Node	next;
		int		data;
		
		public Node(int data)
		{
			this.data = data;
		}// end Node - constructor
	}// end Node - class
	
	Node head;
	
	public void append(int data)
	{
		if (head == null)
		{
			head = new Node(data);
			return;
		}// end if
		
		Node current = head;
		while (current.next != null)
			current = current.next;
		current.next = new Node(data);
	}// end append
	
	public void prepend(int data)
	{
		Node newHead;
		
		newHead			= new Node(data);
		newHead.next	= head;
		head			= newHead;
	}// end prepend
	
	public void deleteWithValue(int data)
	{
		if (head == null)
			return;
		if (head.data == data)
		{
			head = head.next;
			return;
		}// end if
		
		Node current = head;
		while (current.next != null)
		{
			if (current.next.data == data)
			{
				current.next = current.next.next;
				return;
			}// end if
			
			current = current.next;
		}// end while
	}// end deleteWithValue
	
	void printLinkedList()
	{
		Node tmp = head;
		while (tmp != null)
		{
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}// end while
		System.out.println();
	}// end printLinkedList
	
	public static void main(String[] args)
	{
		LinkedList ll = new LinkedList();
		ll.append(7);
		ll.printLinkedList();
		
		ll.prepend(5);
		ll.printLinkedList();
		
		ll.append(42);
		ll.printLinkedList();
		
		ll.deleteWithValue(7);
		ll.printLinkedList();
		
		ll.deleteWithValue(5);
		ll.printLinkedList();
		
		ll.deleteWithValue(10);
		ll.printLinkedList();
	}// end main
}// end LinkedList - class
