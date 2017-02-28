package corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class CollectionsTest {

	public static void main(String[] args) {
		
		int one;
		one = 1;	
		one = one =one=one;
		
		Set<Integer> intgerSet = new HashSet<>();
		intgerSet.add(1);
		intgerSet.add(1);
		intgerSet.add(2);
		intgerSet.add(3);
		Integer[] intArr = new Integer[6];
		intgerSet.toArray(intArr);
		System.out.println( Arrays.deepToString(intArr) );
		
		
		List<Integer> intList = new ArrayList<>();
		intList.addAll(intgerSet);
		intList.add(1,3);
		System.out.println(intList);
	
		SortedSet<Integer> intSortedSet = new TreeSet<>(intgerSet);
		System.out.println(intSortedSet.first());
		System.out.println(intSortedSet.last());
		System.out.println(intSortedSet.comparator());
		
		NavigableSet<Integer> intNavSet = new TreeSet<>();
		intNavSet.add(1);
		intNavSet.add(2);
		intNavSet.add(3);
		intNavSet.add(4);
		intNavSet.add(5);
		intNavSet.add(6);
		intNavSet.add(7);
		intNavSet.add(8);
		intNavSet.add(9);
		intNavSet.add(10);
		intNavSet.add(12);
		
		System.out.println(intNavSet.floor(11));

		System.out.println(intNavSet.removeIf(IntegerPredicate.isGreaterThan(9)));
		System.out.println(intNavSet);
		System.out.println(intNavSet.headSet(4));
		System.out.println(intNavSet.higher(6));
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(1);
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		
		System.out.println(queue);
		
		Deque<Integer> dQueue = new LinkedList<>();
		dQueue.push(1);
		dQueue.push(4);
		dQueue.offer(2);
		dQueue.offer(3);
		dQueue.offerFirst(5);
		dQueue.offerLast(6);
		System.out.println(dQueue);
		
		
		LinkedList<String> l1 = new LinkedList<String>();
		l1.add("A");
		l1.add("A");
		l1.add("B");
		l1.addLast("C");
		l1.addFirst("0");
		System.out.println(l1);
		
		HashSet<String> h1 = new HashSet<String>();
		h1.add("A");
		h1.add("BA");
		h1.add("C");
		h1.add("D");
		h1.add("E");
		
		System.out.println(h1);
		
		LinkedHashSet<String> lh1 = new LinkedHashSet<String>();
		lh1.add("A");
		lh1.add("BA");
		lh1.add("C");
		lh1.add("D");
		lh1.add("E");
		
		System.out.println(lh1);
		
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("C");
		ts.add("A");
		ts.add("B");
		ts.add("E");
		ts.add("F");
		ts.add("D");
		System.out.println(ts);
		
		boolean b = true | false; 
		
	}

}
