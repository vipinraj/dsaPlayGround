/**
 * 12.8
 */
package epi.searching;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class KthLargestElement {
  
  
  public static void main(String[] args) { 
    List<Integer> arr = new ArrayList<>(Arrays.asList(3,2,4,18,1,9,6,10));
    System.out.println(arr.get(kthLargest(arr, 3)));
  }
  
  
  
  public static int getLargest(List<Integer> arr, int start, int end) {
    int maxPos;
    maxPos = start;
    
    for (int i = start + 1; i <= end; i++) {
      if (arr.get(i) > arr.get(maxPos)) {
        maxPos = i;
      }
    }
    
    return maxPos;
  }
}
