/**
 * 
 */
package epi.searching;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
  
  
  public static void main(String[] args) { 
    List<Integer> input = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11));
    System.out.println(findElement(input, 11));
  }
  
  public static int findElement(List<Integer> arr, Integer e) {
    int l = 0;
    int r = arr.size() - 1;
    
    while (l <= r) {      
      int m = l + (r - l) / 2;
      if (arr.get(m) == e) {
        return m;
      } else if (e < arr.get(m)) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    
    return -1;
  }
  
}
