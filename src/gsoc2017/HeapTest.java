package gsoc2017;

/**
 * @author vipin
 *
 */
public class HeapTest {

	public static void main(String[] args) throws Exception {
		
		MaxHeap maxheap = new MaxHeap(10);
		maxheap.insert(1);
		maxheap.insert(2);
		maxheap.insert(3);
		maxheap.insert(4);
		System.out.println(maxheap.extractMax());
		maxheap.insert(5);
		maxheap.insert(6);
		System.out.println(maxheap.peek());
		
		MinHeap minheap = new MinHeap(10);
		minheap.insert(6);
		minheap.insert(4);
		minheap.insert(2);
		minheap.insert(1);
		minheap.insert(3);
		System.out.println(minheap.extractMin());
		minheap.insert(5);
		System.out.println(minheap.peek());
	}

}
