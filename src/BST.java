class Node
{
	Node	left;
	Node	right;
	int		data;
	
	public Node(int data)
	{
		this.data = data;
	}// end Node - constructor
	
	public void insert(int value)
	{
		if (value <= data)
		{
			if (left == null)
				left = new Node(value);
			else
				left.insert(value);
		}
		else
		{
			if (right == null)
				right = new Node(value);
			else
				right.insert(value);
		}// end if - else
	}// end insert
	
	public boolean contains(int value)
	{
		if (value == data)
			return true;
		
		if (value < data)
		{
			if (left == null)
				return false;
			else
				return left.contains(value);
		}
		else
		{
			if (right == null)
				return false;
			else
				return right.contains(data);
		}// end if - else
	}// end contains
	
	public void printInOrder()
	{
		if (left != null)
			left.printInOrder();
		System.out.println(data);
		if (right != null)
			right.printInOrder();
	}// end printInOrder
	
}// end Node - class

public class BST
{
	public static void main(String[] args)
	{
		Node bst = new Node(5);
		bst.insert(3);
		bst.insert(7);
		bst.printInOrder();
	}// end main
}// end BST - class
