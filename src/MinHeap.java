import java.util.Arrays;

public class MinHeap
{
	private int	capacity	= 10;
	private int	size		= 0;
	
	int[]		items		= new int[capacity];
	
	private int getLeftChildIndex(int parentIndex)
	{
		return 2 * parentIndex + 1;
	}// end getLeftChildIndex
	
	private int getRightChildIndex(int parentIndex)
	{
		return 2 * parentIndex + 2;
	}// end getRightChildIndex
	
	private int getParentIndex(int childIndex)
	{
		return (childIndex - 1) / 2;
	}// end getParentIndex
	
	private boolean hasLeftChild(int index)
	{
		return getLeftChildIndex(index) < size;
	}// end hasLeftChild
	
	private boolean hasRightChild(int index)
	{
		return getRightChildIndex(index) < size;
	}// end hasRightChild
	
	private boolean hasParent(int index)
	{
		return getParentIndex(index) >= 0;
	}// end hasParent
	
	private int leftChild(int index)
	{
		return items[getLeftChildIndex(index)];
	}// end leftChild
	
	private int rightChild(int index)
	{
		return items[getRightChildIndex(index)];
	}// end rightChild
	
	private int parent(int index)
	{
		return items[getParentIndex(index)];
	}// end parent
	
	private void swap(int i, int j)
	{
		int tmp;
		tmp			= items[i];
		items[i]	= items[j];
		items[j]	= tmp;
	}// end swap
	
	private void ensureExtraCapacity()
	{
		if (size == capacity)
		{
			items		= Arrays.copyOf(items, capacity * 2);
			capacity	*= 2;
		}// end if
	}// end ensureExtraCapacity
	
	public int peek()
	{
		if (size == 0)
			throw new IllegalStateException();
		return items[0];
	}// end peek
	
	public int poll()
	{
		if (size == 0)
			throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;
	}// end poll
	
	public void add(int item)
	{
		ensureExtraCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}// end add
	
	public void heapifyUp()
	{
		int index = size - 1;
		while (hasParent(index) && parent(index) > items[index])
		{
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}// end while
	}// end heapifyUp
	
	public void heapifyDown()
	{
		int index = 0;
		while (hasLeftChild(index))
		{
			int smallerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) < leftChild(index))
				smallerChildIndex = getRightChildIndex(index);
			
			if (items[index] < items[smallerChildIndex])
				break;// TODO: See if this is necessary
			else
				swap(index, smallerChildIndex);
			
			index = smallerChildIndex;
		}// end while
	}// end heapifyDown
}// end MinHeap - class
