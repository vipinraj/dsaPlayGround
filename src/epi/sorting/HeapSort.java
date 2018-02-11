/**
 * Algorithm
 */

package epi.sorting;

public class HeapSort {
  
  
  public static void main(String[] args) { 
    int a[] = { 9, 8, 5,7, 6, 5, 4, 3, 3, 2, 1, 8};
    heapify(a, a.length);
    heapSort(a);
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
  }
  
  public static void heapSort(int a[]) {
    for (int i = a.length - 1; i > 0; i--) {
      int tmp = a[i];
      a[i] = a[0];
      a[0] = tmp;
      maxHeapify(a, 0, i);
    }
  }
  
  public static void heapify(int a[], int size) {
    for (int i = size / 2 - 1; i >= 0; i--) {
      maxHeapify(a, i, size);
    }
  }
  
  public static void maxHeapify(int a[], int idx, int size) {
    
    int largest;
    
    if (left(idx) < size && a[left(idx)] > a[idx]) {
      largest = left(idx);
    } else {
      largest = idx;
    }
    
    if (right(idx) < size && a[right(idx)] > a[largest]) {
      largest = right(idx);
    }
    
    if (largest != idx) {
      int tmp = a[largest];
      a[largest] = a[idx];
      a[idx] = tmp;
      maxHeapify(a, largest, size);
    }
    
  }
  
  public static int left(int i) {
    return i * 2 + 1;
  }

  public static int right(int i) {
    return i * 2 + 2;
  }
  
}
