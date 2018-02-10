/**
 * Algorithm
 */
package epi.sorting;

public class MergeSort {
  
  
  public static void main(String[] args) { 
    int[] a = { 100,5, 2, 3, 4, 3, 7, 0, 9, 10};
    mergeSort(a, 0, a.length - 1);
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + ", ");      
    }
  }
  
  public static void mergeSort(int a[], int i, int j) {
    if (i < j) {
      int mid = i + (j - i) / 2;
      mergeSort(a, i, mid);
      mergeSort(a, mid + 1, j);
      merge(a, i, mid, j);
    }
  }
  
  // based on CLRS
  public static void merge(int a[], int start, int mid, int end) {
    
    int left[] = new int[mid - start + 2];
    int right[] = new int[end - mid + 1];
    
    for (int i = 0; i < left.length - 1; i++) {
      left[i] = a[i + start];
    }
    left[left.length - 1] = Integer.MAX_VALUE;
    
    for (int i = 0; i < right.length - 1; i++) {
      right[i] = a[i + mid + 1];
    }
    right[right.length - 1] = Integer.MAX_VALUE;
    
    int leftIdx = 0;
    int rightIdx = 0;
    
    for (int i = start; i <= end; i++) {
      if (left[leftIdx] < right[rightIdx]) {
        a[i] = left[leftIdx];
        leftIdx++;
      } else {
        a[i] = right[rightIdx];
        rightIdx++;
      }
    }
  }
  
}
