/**
 * Auto Generated Java Class.
 */
package epi.heap;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;

public class IncreaseDecreaseArraySort {
  
  
  public static void main(String[] args) { 
    ArrayList<Integer> input = new ArrayList<>(Arrays.asList(57,131,493,294,221,339,418,452,442,190,
                                                             12,15,200,25,22,32,422,569,421,121,23));
    ArrayList<Integer> result = getSortedList(input);
    System.out.println();
    System.out.println(result);
  }
  
  public static ArrayList<Integer> getSortedList(ArrayList<Integer> arr) {
    boolean forward = true;
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(16);
    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int i = 0; i < arr.size() - 5; i += 5) {
      System.out.print(i + ", ");
      System.out.print(i+4 + " \n");
      minHeap.add(arr.get(i));
      minHeap.add(arr.get(i+4));
    }
    System.out.println(minHeap.peek());
    int i = 0;
    int offset = 1;
    while(!minHeap.isEmpty()) {
      result.add(minHeap.poll());
      if (i + offset < i + 4 - offset) {
        if (!forward) {
          minHeap.add(arr.get(i + 4 - offset));
          System.out.print(i + 4 - offset + "\n");
          i = i + 5;
        } else {
          System.out.print(i + offset + ",");
          minHeap.add(arr.get(i + offset));
        }
        if (i + 5 > arr.size()) {
          i = 0; 
          offset++;
        }
      }
      forward = !forward;
    }
    return result;
  }
  
  
  
}
