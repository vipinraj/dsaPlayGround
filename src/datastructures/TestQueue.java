package datastructures;

public class TestQueue {

	public static void main(String[] args) throws Exception {
		
		Queue queue = new Queue(5);
		
		queue.enqueue(10);
		queue.enqueue(11);
		queue.enqueue(12);
		queue.enqueue(13);
		queue.enqueue(14);
		
		System.out.println(queue.dequeue());
		queue.enqueue(19);
		System.out.println(queue.dequeue());
		
		System.out.println("------------------queue using stacks");
		
		QueueUsingStacks qus = new QueueUsingStacks(4);
		qus.enqueue(56);
		qus.enqueue(556);
		qus.enqueue(596);
		qus.enqueue(5);
		//qus.enqueue(9);
		System.out.println(qus.dequeue());
		qus.enqueue(89);
		System.out.println(qus.dequeue());
		System.out.println(qus.dequeue());
		System.out.println(qus.dequeue());
		System.out.println(qus.dequeue());
		//System.out.println(qus.dequeue());
		
	}

	
}
