package epi.heap;

import java.util.PriorityQueue;
import java.util.Comparator;

public class QueueUsingHeap {
    public static void main(String args[]) throws Exception {
        Queue queue = new Queue();
        queue.add(8);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(9);
        queue.add(0);
        
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}

class ValuesWithRank {
    Integer value;
    Integer rank;
    
    ValuesWithRank(Integer value, Integer rank) {
        this.value = value;
        this.rank = rank;
    }
}

class Queue {
    private int globalRank = 0;
    private PriorityQueue<ValuesWithRank> heap;
    Queue() {
        heap = new PriorityQueue<ValuesWithRank>(16, new Comparator<ValuesWithRank>() {
        @Override
        public int compare(ValuesWithRank a, ValuesWithRank b) {
            return Integer.compare(a.rank, b.rank);
        }
    }); // max heap
    }
    
    public void add(Integer value ){
        heap.add(new ValuesWithRank(value, globalRank));
        globalRank ++;
    }
    
    public Integer poll() throws Exception {
        if (this.heap.isEmpty()) {
            throw new Exception("Queue underflow!");
        }
        return heap.poll().value;
    }
    
    public boolean isEmpty() {
        return this.heap.isEmpty();
    }
    
}