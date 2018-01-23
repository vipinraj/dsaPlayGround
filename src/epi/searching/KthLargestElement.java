/**
 * 12.8 and variants
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
    
    System.out.println(kthLargest(arr, 2));
    arr = new ArrayList<>(Arrays.asList(1,2,3,4));
    System.out.println(getMedian(arr));
    arr = new ArrayList<>(Arrays.asList(1,2,3,4));
    System.out.println(getMedian(arr));
    arr = new ArrayList<>(Arrays.asList(1,2,3));
    System.out.println(getMedian(arr));
  }
  
  public static Integer kthLargest(List<Integer> a, int k) {
    int r = a.size() - 1;
    int l = 0;
    int m;
    Random random = new Random();
    int pivotIdx;
    
    while (l <= r) {
        m = random.nextInt((r - l) + 1) + l;
        pivotIdx = partitionByM(a, l, r, m);
        if (pivotIdx == k - 1) {
            return a.get(pivotIdx);
        } else if (pivotIdx < k - 1) {
            l =  pivotIdx + 1;      
        } else {
            r = pivotIdx - 1;
        }
    }
    return null;
  }
  
  public static int partitionByM(List<Integer> a, int l, int r, int m) {
      int mElement = a.get(m);
      int i = l;
      int pos = l;

      Collections.swap(a, m, r);

      while (i < r) {
          if (a.get(i) > mElement) {
              Collections.swap(a, pos, i);
              pos++;
          }
          i++;
      }
      Collections.swap(a, pos, r);
      return pos;
  }
  
  public static double getMedian(List<Integer> a) {
      int l = 0;
      int r = a.size() - 1;
      int k = ((a.size() - 1) / 2) + 1;
      System.out.println("K:" + k);
      double median = 0;
      Random rand = new Random();
      while (l <= r) {
          int m = rand.nextInt(r - l + 1) + l;
          int pivot = partitionByM(a, l, r, m);
          if (pivot == k - 1) {
              if (a.size() % 2 == 1) { // odd num of elements
                  return a.get(pivot);
              } else { //even
                  if (k == a.size() / 2  + 1) { // first middle element is alredy found
                      System.out.println("Median elem 2: " + a.get(pivot));
                      return ((double)a.get(pivot) + median) / 2.0;
                  }
                  k++;
                  System.out.println("Median elem 1: " + a.get(pivot));
                  median = a.get(pivot);
              }
          } else if (pivot > k - 1) {
              r = pivot - 1;
          } else {
              l = pivot + 1;
          }
      }
      return 0;
  }
 
}
