/**
 * 12.2
 */
package epi.searching;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class EntryEqualsIndex {
  
  
  public static void main(String[] args) { 
    List<Integer> input = new ArrayList<>(Arrays.asList(-2,0,2,3,6,7,9));
    System.out.println(findElement(input));
  }
  
 public static int findElement(List<Integer> arr) {
    int l = 0;
    int r = arr.size() - 1;
    
    while (l <= r) {      
      int m = l + (r - l) / 2;
      if (arr.get(m) == m) {
        return m;
      } else if (m < arr.get(m)) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    
    return -1;
  }
  
}
