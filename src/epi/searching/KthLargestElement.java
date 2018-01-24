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
    
    List<Element> elemArr = new ArrayList<>();
    elemArr.add(new Element(2, 'a'));
    elemArr.add(new Element(3, 'a'));
    elemArr.add(new Element(2, 'b'));
    elemArr.add(new Element(0, 'a'));
    elemArr.add(new Element(8, 'a'));
    elemArr.add(new Element(4, 'a'));
    elemArr.add(new Element(7, 'a'));
    elemArr.add(new Element(7, 'b'));
    elemArr.add(new Element(7, 'c'));
    elemArr.add(new Element(1, 'a'));
    System.out.println(ktheLargestWithDuplicates(elemArr, 2));
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
  
  // stable sorting not implemented
  public static Element ktheLargestWithDuplicates(List<Element> a, int k){
      
      int left = 0;
      int right = a.size() - 1;
      
      while (left <= right) {
        Random r = new Random();
        int pivotIdx = r.nextInt(right - left + 1) + left;
        int pivotIdxupdated = partitionByPivot(a, left, right, pivotIdx);
        if (pivotIdxupdated == k - 1) {
            return a.get(pivotIdxupdated);
        } else if (pivotIdxupdated > k - 1) {
            right = pivotIdxupdated - 1;
        } else {
            left = pivotIdxupdated + 1;
        }
      }
      
      return null;
  }
  
  public static int partitionByPivot(List<Element> a, int left, int right, int pivotIdx) {
      Integer swappedIdx = null;
      if (a.get(pivotIdx).compareTo(a.get(right)) != 0) {
        Collections.swap(a, pivotIdx, right);
        swappedIdx = pivotIdx;
      }
      int pos = left;
      Element pivotElem = a.get(right);
      for (int i = left; i < right; i++) {
          int compareResult = a.get(i).compareTo(pivotElem);
          
          if (i > pivotIdx) {
              
              if (a.get(i).compareTo(a.get(swappedIdx)) == 0) {
                  Collections.swap(a, swappedIdx, i);
                  swappedIdx = i;
              }
             
              if (compareResult == 0) {
                  Collections.swap(a, i, right);
              }   
          }
          if (compareResult >= 0)  {
              Collections.swap(a, pos++, i);
              if (i == pivotIdx) {
                  swappedIdx = pos - 1;
              }
          }
      }
      Collections.swap(a, pos, right);

      return pos;
  }
}
  class Element implements Comparable<Element> {
      int key;
      char val;
      
      Element(int key, char val) {
          this.key = key;
          this.val = val;
      }
      
      public int compareTo(Element o){
        return Integer.compare(this.key, o.key);
      }
      public String toString() {
        return "Key: " + key + ", Val: " + val;
      }
  }