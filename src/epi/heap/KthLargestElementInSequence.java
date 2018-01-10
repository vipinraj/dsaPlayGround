package epi.heap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KthLargestElementInSequence {
    public static void main(String args[]) {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,3,45,6,7,4,6,87,12,10,12,32,45,76,0,9,11,80));
        printKthLargestElementSoFar(input.iterator(), 5);
    }
    
    public static void printKthLargestElementSoFar(Iterator<Integer> input, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        while(input.hasNext()) {

            Integer val = input.next();
            if (minHeap.size() < k) {
                minHeap.add(val);
            } else {
                System.out.println(minHeap.peek());
                if (minHeap.peek() < val) {
                    minHeap.add(val);
                    if (minHeap.size() > k) {
                        minHeap.poll();
                    }
                }
            }

        }
    }
    
}
