/**
 * 10.3
 */
package epi.heap;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SortAlmostSortedArray {
  
  
  public static void main(String[] args) { 
    List<Integer> input = new ArrayList<Integer>(Arrays.asList(3,-1,2,6,4,5,8));
    System.out.println(sort(input, 2));
  }
  
  /* O(nlogk), O(k) */
  public static List<Integer> sort(List<Integer> input, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    List<Integer> result = new ArrayList<>();
    int i;
    for (i = 0; i <= k; i++) {
      minHeap.add(input.get(i));
    }
    
    while (!minHeap.isEmpty()) {
      result.add(minHeap.poll());
      if (i < input.size()) {
        minHeap.add(input.get(i));
        i++;
      }
    }
    
    return result;
  }
  
}
