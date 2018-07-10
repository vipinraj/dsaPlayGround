package corejava;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerTest {
	public static void main(String[] args) {
		final Queue<Integer> sharedQ = new LinkedList<>();
		Thread producer = new Producer(sharedQ);
		Thread consumer = new Consumer(sharedQ);
		producer.start();
		consumer.start();
	}
}

class Producer extends Thread {
	private final Queue<Integer> sharedQ;
	
	public Producer(Queue<Integer> sharedQ) {
		this.sharedQ = sharedQ;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			
			synchronized(sharedQ) {
				while (sharedQ.size() >= 2) {
					try {
						System.out.println("Queue is full! waiting...");
						sharedQ.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("producing : " + i);
				sharedQ.add(i);
				sharedQ.notify();
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
}

class Consumer extends Thread {
	private final Queue<Integer> sharedQ;
	
	public Consumer(Queue<Integer> sharedQ) {
		this.sharedQ = sharedQ;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized(sharedQ) {
				while(sharedQ.size() == 0) {
					try {
						System.out.println("Queue is empty! waiting...");
						sharedQ.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				int number = sharedQ.poll();
				System.out.println("consuming : " + number);
				sharedQ.notify();
				
				if (number == 3) {
					break;
				}
			}
		}
	}
}