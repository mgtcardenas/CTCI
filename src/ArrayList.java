import java.util.Arrays;

public class ArrayList
{
	private int		capacity	= 10;
	private int		size		= 0;
	private int[]	items		= new int[capacity];
	
	public void add(int value)
	{
		ensureExtraCapacity();
		items[size++] = value;
	}// end add
	
	private void ensureExtraCapacity()
	{
		if (size == capacity)
		{
			items		= Arrays.copyOf(items, items.length * 2);
			capacity	*= 2;
		}// end if
	}// end ensureExtraCapacity
	
	public void printItems()
	{
		for (int i = 0; i < size - 1; i++)
			System.out.print(items[i] + ", ");
		System.out.println(items[size - 1]);
	}// end printItems
	
	public int size()
	{
		return size;
	}// end size
	
	public int capacity()
	{
		return capacity;
	}// end capacity
	
	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		al.add(6);
		al.add(7);
		al.add(8);
		al.add(9);
		al.add(10);
		System.out.println("Size of: " + al.size() + " Capacity of: " + al.capacity());
		al.add(11);
		System.out.println("Size of: " + al.size() + " Capacity of: " + al.capacity());
	}// end main
}// end ArrayList - class
