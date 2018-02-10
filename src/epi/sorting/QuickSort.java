package epi.sorting;
import java.util.Random;
/**
 * Algorithm
 */
public class QuickSort {
  
  
  public static void main(String[] args) { 
    int[] a = {5,2,3,4,3,7,0,9,10};
    quickSort(a, 0, a.length-1);
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + ", ");      
    }
    System.out.println();
    int[] b = {5,2,3,4,3,7,0,9,10};
    quickSortRandomized(b, 0, b.length-1);
    for (int i = 0; i < b.length; i++) {
      System.out.print(b[i] + ", ");      
    }
    
  }
  
  public static void quickSort(int a[], int i, int j) {
    if (i < j) {
      int m = partition(a, i, j);
      quickSort(a, i, m-1);
      quickSort(a, m+1, j);
    }
  }
  
  public static int partition(int a[], int i, int j) {
    int p = a[i];
    int m = i;
    
    for (int k = i + 1; k <= j; k++) {
      if (a[k] < p) {
        m++;
        swap(a, m, k);
      }
    }
    swap(a, m, i);
    
    return m;
  }
  
 public static void quickSortRandomized(int a[], int i, int j) {
    if (i < j) {
      int m = randomPartition(a, i, j);
      quickSort(a, i, m-1);
      quickSort(a, m+1, j);
    }
  }
 
  public static int randomPartition(int a[], int i, int j) {
    
    Random r = new Random(0);
    int pIdx = r.nextInt(j - i + 1) + i;
    int p = a[pIdx];
    int m = i;
    
    swap(a, pIdx, j);
    for (int k = i; k < j; k++) {
      if (a[k] < p) {
        swap(a, m, k);
        m++;
      }
    }
    swap(a, m, j);
    
    return m;
  }
 
  public static void swap(int a[], int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
  
}
