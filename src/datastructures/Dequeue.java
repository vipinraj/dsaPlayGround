package datastructures;

/*
 * 1. Let head = tail = -1 initially
 * 2. When first element is entered at head or tail insert it into 0 the position
 *    and make head = tail = 0
 * 3. When the difference b/w head and tail is one the queue is full
 * 4. If head = tail, queue has only one element
 * 5. If queue has only one element and, it is to be deleted, make head = tail = -1    
 */

public class Dequeue {
	Integer[] S;

	Integer head = -1;
	Integer tail = -1;
	Integer length;

	public Dequeue(Integer length) {
		this.length = length;
		S = new Integer[length];
	}

	public boolean isEmpty() {

		if (head == -1 || tail == -1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {

		if ((tail + 1) % length == head) {
			return true;
		} else {
			return false;
		}
	}

	// append to the right
	public void append(Integer element) throws Exception {		
		if (isEmpty()) {
			// first element
			head = 0;
			tail = 0;
			S[tail] = element;
		} else {

			if (isFull()|| length == 1) {
				throw new Exception("Queue is full!");
			}

			tail = (tail + 1) % length;
			S[tail] = element;

		}
		printHeadNTail();
	}

	// append to the left
	public void prepend(Integer element) throws Exception {
		printHeadNTail();
		if (head == -1 || tail == -1) {
			// first element
			head = 0;
			tail = 0;
			S[head] = element;
		} else {

			if (isFull() || length == 1) {
				throw new Exception("Queue is full!");
			}

			head = (head - 1) % length;
			if (head < 0) {
				head += length;
			}
			S[head] = element;

		}
		printHeadNTail();
	}

	// pop from left
	public Integer pop_head() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is empty!");
		}
		if(head == tail){ //has only one element
			Integer element = S[head];
			head = -1;
			tail = -1;
			printHeadNTail();
			return element;
		}
		Integer element = S[head];
		head = (head + 1) % length;
		printHeadNTail();
		return element;
	}

	// pop from right
	public Integer pop_tail() throws Exception {
		
		if (isEmpty()) {
			throw new Exception("Queue is empty!");
		}
		if(head == tail){ //has only one element
			Integer element = S[head];
			head = -1;
			tail = -1;
			printHeadNTail();
			return element;
		}
		Integer element = S[tail];
		tail = (tail - 1) % length;
		if (tail < 0) {
			tail += length;
		}
		printHeadNTail();
		return element;
	}
	
	public void printHeadNTail(){
		System.out.println("Head: " + head + ", Tail: " + tail);
	}

}
