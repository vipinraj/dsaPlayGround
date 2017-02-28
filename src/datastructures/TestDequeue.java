package datastructures;

public class TestDequeue {

	public static void main(String args[]) throws Exception{
		Dequeue dq = new Dequeue(5);
		dq.append(45);
		dq.append(65);
		dq.append(70);
		dq.pop_tail();
		dq.prepend(89);
		dq.prepend(57);
		dq.prepend(56);
		System.out.println(dq.pop_head());
		System.out.println(dq.pop_tail());
		dq.pop_head();
		dq.pop_head();
		dq.pop_head();
	}
	
}