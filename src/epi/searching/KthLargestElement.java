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
    arr.get(kthLargest(arr, 2));
  }
  
  public static int kthLargest(List<Integer> a, int k) {
    int r = a.size() - 1;
    int l = 0;
    int m;
    Random random = new Random(0);
    int pivotIdx = -1;
    
    while (l <= r) {
        m = random.nextInt((r - l) + 1) + l;
        pivotIdx = partitionByM(a, l, r, m);
        if (r - pivotIdx + 1 == k) {
            return pivotIdx;
        } else if (r - pivotIdx + 1 > k) {
            l =  pivotIdx + 1;      
        } else {
            r = pivotIdx - 1;
            k = k - (r - pivotIdx + 1);
        }
    }
    return pivotIdx;
  }
  
  public static int partitionByM(List<Integer> a, int l, int r, int m) {
      int mElement = a.get(m);
      int i = l + 1;
      int pos = l;

      Collections.swap(a, m, r);      
      while (i < r) {
          if (a.get(i) < mElement) {
              Collections.swap(a, pos, i);
              pos++;
          }
          i++;
      }
      Collections.swap(a, pos, r);
      System.out.println(mElement);
      System.out.println(pos);
      System.out.println(a);
      return pos;
  }
 
}
