/**
 * Algorithm
 */
package epi.sorting;

public class InsertionSort {
  
  
  public static void main(String[] args) { 
    int[] a = { 100,5, 2, 3, 4, 3, 7, 0, 9, 10};
    sort(a);
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + ", ");      
    }
  }
  
  public static void sort(int a[]) {
    
    for (int i = 1; i < a.length; i++) {
      int e = a[i];
      int k = i - 1;
      
      while ( k >= 0 && e < a[k]) {
        a[k + 1] = a[k];
        k--;
      }
      a[k + 1] = e;
    }
  }
  
}
