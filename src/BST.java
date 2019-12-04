public class BST
{
	private static class Node
	{
		Node	left;
		Node	right;
		int		data;
		
		private Node(int data)
		{
			this.data = data;
		}// end Node - constructor
		
		private void insert(int value)
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
		
		private boolean contains(int value)
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
		
		private void printInOrder()
		{
			if (left != null)
				left.printInOrder();
			System.out.println(data);
			if (right != null)
				right.printInOrder();
		}// end printInOrder
	}// end Node - class
	
	Node root;
	
	private void insert(int value)
	{
		if (root == null)
			root = new Node(value);
		else
			root.insert(value);
	}// end insert
	
	private boolean contains(int value)
	{
		if (root == null)
			return false;
		else
			return root.contains(value);
	}// end contains
	
	private void printInOrder()
	{
		if (root != null)
			root.printInOrder();
	}// end printInOrder
	
	public static void main(String[] args)
	{
		BST bst = new BST();
		bst.insert(5);
		bst.insert(3);
		bst.insert(7);
		bst.insert(4);
		bst.printInOrder();
	}// end main
}// end BST - class
