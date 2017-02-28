package datastructures.linkedlist;

public class TestLinkedList {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		Node node1 = new Node((Integer)10);
		Node node2 = new Node((Integer)11);
		Node node3 = new Node((Integer)12);
		Node node4 = new Node((Integer)13);
		
//		list.insert(node1);
//		list.insert(node2);
		list.insert(node3);
//		list.insert(node4);
		list.delete(node3);
		System.out.println(list.search(13).data);
		
		System.out.println(list.head.data);
		list.reverse();
		System.out.println(list.head.next.data);
		
		System.out.println("--------------------------------------");
		LinkedListCircular cList = new LinkedListCircular();
		
		cList.insert(node1);
		cList.insert(node2);
		cList.insert(node3);
		cList.insert(node4);
		cList.delete(node3);
		cList.insert(node3);
		
		System.out.println(cList.search(12).data);
	}

}
