/**
 * 12.1
 */
package epi.searching;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FirstOccuranceOfK {
  
  
  public static void main(String[] args) { 
    List<Integer> input = new ArrayList<>(Arrays.asList(0,1,1,2,3,4,4,4,4,8,9,10,11));
    System.out.println(findFirstOccurance(input, 4));
  }
  
  // nlogn
  public static int findFirstOccurance(List<Integer> arr, Integer k) {
    int l = 0;
    int r = arr.size() - 1;
    int foundIdx = -1;
    
    while (l <= r) {
      System.out.println("l: " + l + " r: " + r);
      int m = l + (r - l) / 2;
      if (arr.get(m) == k) {
        foundIdx = m;
        r = m - 1;
      } else if (arr.get(m) > k) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    
    return foundIdx;
  }
  
}
