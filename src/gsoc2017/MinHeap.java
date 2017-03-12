package gsoc2017;

/**
 * @author vipin
 *
 */
public class MinHeap extends Heap {

	public MinHeap(Integer length) {
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

		while (this.parent(childIndex) >= 0 && this.heap[this.parent(childIndex)] > this.heap[childIndex]) {
			Integer k = this.heap[childIndex];
			Integer parentIndex = this.parent(childIndex);
			this.heap[childIndex] = this.heap[parentIndex];
			this.heap[parentIndex] = k;
			childIndex = parentIndex;
		}
		size++;
	}
	
	//maintain min heap property of a single node
	private void minHeapify(Integer i) {
		Integer l = this.left(i);
		Integer r = this.right(i);
		Integer smallest;

		if (l < this.size && this.heap[l] < this.heap[i]) {
			smallest = l;
		} else {
			smallest = i;
		}

		if (r < this.size && this.heap[r] < this.heap[smallest]) {
			smallest = r;
		}

		if (smallest != i) {
			Integer tempi = this.heap[i];
			this.heap[i] = this.heap[smallest];
			this.heap[smallest] = tempi;
			this.minHeapify(smallest);
		}
	}

	//remove and return the top element from the heap 
	public Integer extractMin() throws Exception {
		if (this.size == 0) {
			throw new Exception("Heap underflow");
		}

		Integer min = this.heap[0];
		this.heap[0] = this.heap[this.size - 1];
		this.size--;
		this.minHeapify(0);
		return min;
	}
}
