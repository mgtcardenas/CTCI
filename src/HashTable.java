import java.util.ArrayList;

public class HashTable<K, V>
{
	private static class Node<K, V>
	{
		K			key;
		V			value;
		Node<K, V>	next;
		
		public Node(K key, V value)
		{
			this.key	= key;
			this.value	= value;
		}// end Node - constructor
	}// end Node - class
	
	private int						numBuckets;
	private int						size;
	private ArrayList<Node<K, V>>	bucketArray;
	
	public HashTable()
	{
		size		= 0;
		numBuckets	= 10;
		bucketArray	= new ArrayList<>(numBuckets);
		
		for (int i = 0; i < numBuckets; i++)
			bucketArray.add(null);
	}// end HashTable - constructor
	
	public int size()
	{
		return size;
	}// end size
	
	public boolean isEmpty()
	{
		return size == 0;
	}// end isEmpty
	
	private int getBucketIndex(K key)
	{
		return key.hashCode() % numBuckets;
	}// end getBucketIndex
	
	public V remove(K key)
	{
		int			bucketIndex	= getBucketIndex(key);
		Node<K, V>	head		= bucketArray.get(bucketIndex);
		Node<K, V>	prev		= null;
		while (head != null && !head.key.equals(key))
		{
			prev	= head;
			head	= head.next;
		}// end while
		
		if (head == null)
			return null;
		
		size--;
		
		if (prev != null)
			prev.next = head.next;
		else
			bucketArray.set(bucketIndex, head.next);
		
		return head.value;
	}// end remove
	
	public V get(K key)
	{
		int			bucketIndex	= getBucketIndex(key);
		Node<K, V>	head		= bucketArray.get(bucketIndex);
		while (head != null)
		{
			if (head.key.equals(key))
				return head.value;
			head = head.next;
		}// end while
		
		return null;
	}// end get
	
	public void add(K key, V value)
	{
		int			bucketIndex	= getBucketIndex(key);
		Node<K, V>	head		= bucketArray.get(bucketIndex);
		while (head != null)
		{
			if (head.key.equals(key))
			{
				head.value = value;
				return;
			}// end if
			head = head.next;
		}// end while
		
		size++;
		head = bucketArray.get(bucketIndex);
		Node<K, V> newNode = new Node<>(key, value);
		newNode.next = head;
		bucketArray.set(bucketIndex, newNode);
	}// end add
	
	public static void main(String[] args)
	{
		HashTable<String, Integer> ht = new HashTable<>();
		System.out.println(ht.isEmpty());
		ht.add("Marco", 1);
		ht.add("Antonio", 2);
		ht.add("Gutierrez", 3);
		ht.add("Cardenas", 4);
		System.out.println(ht.size());
		System.out.println(ht.remove("Marco"));
		System.out.println(ht.remove("Cardenas"));
		System.out.println(ht.size());
		System.out.println(ht.isEmpty());
	}// end main
}// end HashTable - class
