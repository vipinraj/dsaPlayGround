/**
 * 12.2, variant
 */
package epi.searching;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class EntryEqualsIndex {
  
  
  public static void main(String[] args) { 
    List<Integer> input = new ArrayList<>(Arrays.asList(-2,0,2,3,6,7,9));
    System.out.println(findElement(input));
    System.out.println(findElementMethod2(input));
    input = new ArrayList<>(Arrays.asList(0,3,5,5,5,6,7));
    System.out.println(findElementRecursive(input, 0, input.size() - 1));
  }
 
 // nlogn
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
 // method 2 , nlogn
 public static int findElementMethod2(List<Integer> arr) {
    int l = 0;
    int r = arr.size() - 1;
    
    while (l <= r) {      
      int m = l + (r - l) / 2;
      if (arr.get(m) - m == 0) {
        return m;
      } else if (0 < arr.get(m)-m) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    
    return -1;
  }
    // variant 1 (with duplicates)
    public static int findElementRecursive(List<Integer> arr, int l, int r) {
      if (l > r) {
         return -1;
      } else {
          int result;
          int mid = l + (r - l) / 2;
          int midElement = arr.get(mid);
          int lElement = arr.get(l);
          int rElement = arr.get(r);
          if (midElement == mid) {
              return mid;
          } 
          if (lElement >= mid) {
              return findElementRecursive(arr, mid + 1, r);
          } else if (midElement > mid && rElement > r) {
              return findElementRecursive(arr, l, mid - 1);
          } else {
              return (result = findElementRecursive(arr, mid + 1, r)) != -1 ? result :
              findElementRecursive(arr, l, mid - 1);
          }
      }
  }
}
