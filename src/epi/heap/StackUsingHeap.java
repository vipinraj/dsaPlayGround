
package epi.heap;
import java.util.PriorityQueue;
import java.util.Comparator;

public class StackUsingHeap {
    public static void main(String args[]) throws Exception {
        Stack stack = new Stack();
        stack.push(8);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(9);
        stack.push(0);
        
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
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

class Stack {
    private int globalRank = 0;
    private PriorityQueue<ValuesWithRank> heap;
    Stack() {
        heap = new PriorityQueue<ValuesWithRank>(16, new Comparator<ValuesWithRank>() {
        @Override
        public int compare(ValuesWithRank a, ValuesWithRank b) {
            return Integer.compare(b.rank, a.rank);
        }
    });
    }
    
    public void push(Integer value ){
        heap.add(new ValuesWithRank(value, globalRank));
        globalRank ++;
    }
    
    public Integer pop() throws Exception {
        if (this.heap.isEmpty()) {
            throw new Exception("Stack underflow!");
        }
        return heap.poll().value;
    }
    
    public boolean isEmpty() {
        return this.heap.isEmpty();
    }
    
}