package epi.sorting;

public class FastSortList {
	public static void main(String[] args) {
		ListNode<Integer> L = new ListNode<>(6);
		L.next = new ListNode<>(5);
		L.next.next = new ListNode<>(4);
		L.next.next.next = new ListNode<>(1);
		L.next.next.next.next = new ListNode<>(2);
		L.next.next.next.next.next = new ListNode<>(3);

		ListNode<Integer> iter = insertionSort(L);
		while (iter != null) {
			System.out.print(iter.data + ",");
			iter = iter.next;
		}

		// mergeSortedLists test
		ListNode<Integer> L2 = new ListNode<>(1);
		L2.next = new ListNode<>(3);
		L2.next.next = new ListNode<>(8);

		ListNode<Integer> L3 = new ListNode<>(2);
		L3.next = new ListNode<>(4);
		L3.next.next = new ListNode<>(5);
		L3.next.next.next = new ListNode<>(7);
		L3.next.next.next.next = new ListNode<>(11);
		L3.next.next.next.next.next = new ListNode<>(12);

		ListNode<Integer> L4 = mergeSortedLists(L2, L3);
		iter = L4;
		System.out.println();
		while (iter != null) {
			System.out.print(iter.data + ",");
			iter = iter.next;
		}

		// merge sort
		L = new ListNode<>(6);
		L.next = new ListNode<>(5);
		L.next.next = new ListNode<>(4);
		L.next.next.next = new ListNode<>(1);
		L.next.next.next.next = new ListNode<>(2);
		L.next.next.next.next.next = new ListNode<>(3);

		System.out.println();
		iter = mergeSort(L);
		while (iter != null) {
			System.out.print(iter.data + ",");
			iter = iter.next;
		}
	}

	public static ListNode<Integer> insertionSort(ListNode<Integer> L) {
		ListNode<Integer> dummyHead = new ListNode<>(0);
		dummyHead.next = L;
		ListNode<Integer> iter = L;

		while (iter != null && iter.next != null) {
			if (iter.data > (Integer)iter.next.data) {
				ListNode<Integer> prevIter = dummyHead;
				ListNode<Integer> nodeToMove = iter.next;

				while ((Integer)prevIter.next.data < (Integer)nodeToMove.data) {
					prevIter = prevIter.next;
				}

				iter.next = nodeToMove.next;
				nodeToMove.next = prevIter.next;
				prevIter.next = nodeToMove;

			} else {
				iter = iter.next;
			}
		}

		return dummyHead.next;
	}

	public static ListNode<Integer> mergeSort(ListNode<Integer> L) {

		if (L == null || L.next == null) {
			return L;
		}

		// find mid point
		ListNode<Integer> iter1 = L; //fast
		ListNode<Integer> iter2 = L; //slow
		ListNode<Integer> mid = null;
		
		while (iter1 != null && iter1.next != null) {
			iter1 = iter1.next.next;
			mid = iter2;
			iter2 = iter2.next;
		}

		mid.next = null;
		return mergeSortedLists(mergeSort(L), mergeSort(iter2));	
	}

	public static  ListNode<Integer> mergeSortedLists(ListNode<Integer> L1, ListNode<Integer> L2) {
		ListNode<Integer> iter1 = L1;
		ListNode<Integer> iter2 = L2;
		ListNode<Integer> dummyHead = new ListNode<>(0);
		ListNode<Integer> iter3 = dummyHead;

		while(iter1 != null && iter2 != null) {
			if (iter1.data < iter2.data) {
				iter3.next = iter1;
				iter1 = iter1.next;
			} else {
				iter3.next = iter2;
				iter2 = iter2.next;
			}
			iter3 = iter3.next;
		}

		if (iter1 != null) {
			iter3.next = iter1;
		} else {
			iter3.next = iter2;
		}

		return dummyHead.next;
	}	
}

class ListNode<T> {
	T data;
	ListNode next = null;

	ListNode(T data) {
		this.data = data;
	}
}