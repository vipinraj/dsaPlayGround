package datastructures;

public class QueueUsingStacks {
	Stack<Integer> stackOne;
	Stack<Integer> stackTwo;
	Integer size;
	Integer noOfElements = 0;

	public QueueUsingStacks(Integer size) {
		this.size = size;
		stackOne = new Stack<Integer>(size);
		stackTwo = new Stack<Integer>(size);
	}

	public void enqueue(Integer element) throws Exception {
		if (noOfElements == size) {
			throw new Exception("Queue is full!");
		}
		stackOne.push(element);
		noOfElements++;
	}

	public Integer dequeue() throws Exception {
		if(isEmpty()){
			throw new Exception("Queue is empty!");
		}
		if (stackTwo.isEmpty()) {
			while (!stackOne.isEmpty()) {
				stackTwo.push(stackOne.pop());
			}
		}
		noOfElements --;
		return stackTwo.pop();		
	}
	
	public boolean isEmpty(){
		return stackOne.isEmpty() && stackTwo.isEmpty();
	}
}
