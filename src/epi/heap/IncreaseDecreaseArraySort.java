/**
 * 11.2
 */
package epi.heap;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class IncreaseDecreaseArraySort {
  
  
  public static void main(String[] args) { 
    ArrayList<Integer> input = new ArrayList<>(Arrays.asList(57,131,493,294,221,339,418,452,442,190,
                                                             12,15, 200,25, 22, 32, 422,569,421,121));
    List<Integer> result = getSortedList(input);
    System.out.println();
    System.out.println(result);
  }
  // nlogk
  public static List<Integer> getSortedList(ArrayList<Integer> arr) {
    List<List<Integer>> sortedSubArrays = new ArrayList<>();
    boolean isIncreasing = true;
    int startIdx = 0;
    
    // note: i == arr.size() must be the first condition
    // i <= arr.size() to include the last element
    for (int i = 1; i <= arr.size(); i++) {
      if (i == arr.size() || (arr.get(i) < arr.get(i-1) && isIncreasing) || (arr.get(i) > arr.get(i-1) && !isIncreasing)) {
        if (isIncreasing) {
          sortedSubArrays.add(arr.subList(startIdx, i));
        } else {
          List<Integer> subArr = new ArrayList<Integer>();
          subArr = arr.subList(startIdx, i);
          Collections.reverse(subArr);
          sortedSubArrays.add(subArr);
        }
        startIdx = i;
        isIncreasing = !isIncreasing;
      }
    }
    
    
    return MergeSortedArrays.mergeSortedArrays(sortedSubArrays);
  }
  
  
  
}
