/**
 * 11.5
 */
package epi.heap;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Collections;

public class RunningMedian {
  
  
  public static void main(String[] args) { 
    List<Integer> input = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11));
    printRunningMedian(input);
     System.out.println();
    input = new ArrayList<>(Arrays.asList(11,10,9,8,7,6,5,4,3,2,1));
    printRunningMedianMethod2(input);
  }
  
  // my method  nlogn
  public static void printRunningMedian(List<Integer> input) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(16);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(16, Collections.reverseOrder());
    
    for (Integer n : input) {
      if (minHeap.isEmpty()) {
        minHeap.add(n);
        System.out.println(n);
      } else if (maxHeap.isEmpty()) {
        maxHeap.add(n);
        System.out.println(((double)minHeap.peek() + (double)maxHeap.peek())/(double)2);
      } else {
        if (n < maxHeap.peek()) {
          maxHeap.add(n);
        } else {
          minHeap.add(n);
        }
        equalize(minHeap, maxHeap);
        if (maxHeap.size() > minHeap.size()) {
          System.out.println(maxHeap.peek());
        } else if (maxHeap.size() < minHeap.size()) {
          System.out.println(minHeap.peek());
        } else {
          System.out.println(((double)minHeap.peek() + (double)maxHeap.peek())/(double)2);
        }
      }
    }
  }
  // nlogn
  public static void printRunningMedianMethod2(List<Integer> input) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(16);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(16, Collections.reverseOrder());
    
    for (Integer n : input) {
      if (minHeap.isEmpty()) {
        minHeap.add(n);
      } else {
        if (n >= minHeap.peek()) {
          minHeap.add(n);
        } else {
          maxHeap.add(n);
        }
      }
      
      if (minHeap.size() > maxHeap.size() + 1) {
        maxHeap.add(minHeap.poll());
      } else if (maxHeap.size() > minHeap.size()) {
        minHeap.add(maxHeap.poll());
      }
      
      System.out.println(maxHeap.size() == minHeap.size() ? 0.5 * (minHeap.peek() + maxHeap.peek()) : minHeap.peek() + "");
    }
  }
  
  
  public static void equalize(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
    PriorityQueue<Integer> large, small;
    if (Math.abs(minHeap.size() - maxHeap.size()) < 2) 
      return;   
    if (minHeap.size() > maxHeap.size()) {
      large = minHeap;
      small = maxHeap;
    } else {
      large = maxHeap;
      small = minHeap;    
    }
    while (large.size() - small.size() >= 2) {
      small.add(large.poll());
    }
  }
}

  
  