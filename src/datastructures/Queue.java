package datastructures;

public class Queue {
	Integer[] Q;
	Integer head = 0;
	Integer tail = 0;
	Integer length;
	
	public Queue(Integer length) {
		this.Q = new Integer[length];
		this.length = length;
	}
	
	void enqueue(Integer element){
		this.Q[this.tail] = element;
		if(this.tail == this.length - 1){
			this.tail = 0;
		}else{
			this.tail++;
		}
	}
	
	Integer dequeue(){
		Integer x = this.Q[this.head];
		
		if(this.head == this.length - 1){
			this.head = 0;
		}else{
			this.head ++;
		}
		
		return x;
	}
}
