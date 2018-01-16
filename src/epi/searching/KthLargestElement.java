/**
 * 12.8
 */
package epi.searching;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

public class KthLargestElement {
  
  
  public static void main(String[] args) { 
    List<Integer> arr = new ArrayList<>(Arrays.asList(3,2,4,18,1,9,6,10));
    
    System.out.println(kthLargest(arr, 3));
  }
  
  public static Integer kthLargest(List<Integer> a, int k) {
    int r = a.size() - 1;
    int l = 0;
    int m;
    Random random = new Random();
    int pivotIdx;
    
    while (l <= r) {
        m = random.nextInt((r - l) + 1) + l;
        System.out.println("M: " + m);
        System.out.println("[" + l + ", " + r + "]");
        pivotIdx = partitionByM(a, l, r, m);
        if (r - pivotIdx == k - 1) {
            return a.get(pivotIdx);
        } else if (r - pivotIdx < k - 1) {
            l =  pivotIdx + 1;      
        } else {
            r = pivotIdx - 1;
            k = k - (r - pivotIdx + 1);
        }
    }
    return null;
  }
  
  public static int partitionByM(List<Integer> a, int l, int r, int m) {
      int mElement = a.get(m);
      int i = l;
      int pos = l;

      Collections.swap(a, m, r);
      System.out.println(a);
      while (i < r) {
          if (a.get(i) < mElement) {
              Collections.swap(a, pos, i);
              pos++;
          }
          i++;
      }
      Collections.swap(a, pos, r);
      System.out.println("M element: " + mElement);
      System.out.println(a);
      System.out.println("Pos:" + pos);
      return pos;
  }
 
}
