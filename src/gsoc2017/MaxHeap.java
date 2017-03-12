package gsoc2017;

/**
 * @author vipin
 *
 */
public class MaxHeap extends Heap {

	public MaxHeap(Integer length) {
		super(length);
	}
	
	@Override
	//insert a key into heap
	public void insert(Integer key) throws Exception {
		if (this.size == this.heap.length) {
			throw new Exception("Heap overflows!");
		}

		this.heap[size] = key;

		Integer childIndex = size;

		while (this.parent(childIndex) >= 0 && this.heap[this.parent(childIndex)] < this.heap[childIndex]) {
			Integer k = this.heap[childIndex];
			Integer parentIndex = this.parent(childIndex);
			this.heap[childIndex] = this.heap[parentIndex];
			this.heap[parentIndex] = k;
			childIndex = parentIndex;
		}
		size++;
	}
	
	//maintain max heap property of a single node
	private void maxHeapify(Integer i) {
		Integer l = this.left(i);
		Integer r = this.right(i);
		Integer largest;

		if (l < this.size && this.heap[l] > this.heap[i]) {
			largest = l;
		} else {
			largest = i;
		}

		if (r < this.size && this.heap[r] > this.heap[largest]) {
			largest = r;
		}

		if (largest != i) {
			Integer tempi = this.heap[i];
			this.heap[i] = this.heap[largest];
			this.heap[largest] = tempi;
			this.maxHeapify(largest);
		}
	}

	//remove and return the top element from the heap
	public Integer extractMax() throws Exception {
		if (this.size == 0) {
			throw new Exception("Heap underflow");
		}

		Integer max = this.heap[0];
		this.heap[0] = this.heap[this.size - 1];
		this.size --;
		this.maxHeapify(0);
		return max;
	}
}
