/**
 * Alogorithm
 */
package epi.sorting;

public class SelctionSort {
 
  public static void main(String[] args) { 
    int[] a = { 100,5, 2, 3, 4, 3, 7, 0, 9, 10};
    sort(a);
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + ", ");      
    }
  }
  
  public static void sort(int a[]) {
    for (int i = 0; i < a.length; i++) {
      int minIdx = i;
      for (int j = i + 1; j < a.length; j++) {
        if (a[minIdx] > a[j]) {
          minIdx = j;
        }
      }
      
      if (minIdx != i) {
        int tmp = a[minIdx];
        a[minIdx] = a[i];
        a[i] = tmp;
      }
      
    }
  }
  
}
