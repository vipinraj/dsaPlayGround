package gsoc2017;

/**
 * @author vipin
 * Abstract class representing Heap
 */
public abstract class Heap{
	Integer[] heap;
	Integer size = 0;	
	
	public Heap(Integer length) {
		this.heap = new Integer[length];
	}
	
	//get the root element of a heap
	public Integer peek() {
		return this.heap[0];
	}
	
	//get the parent index of a given index
	protected Integer parent(Integer i) {
		return i / 2;
	}

	//get left child index of a given index 
	protected Integer left(Integer i) {
		return 2 * i + 1;
	}

	//get right child index of a given index 
	protected Integer right(Integer i) {
		return 2 * i + 2;
	}
	
	//get the total number of elements in heap
	public Integer size() {
		return this.size;
	}
	
	//insert an element to heap
	abstract void insert(Integer key) throws Exception;
}
