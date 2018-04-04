package epi.sorting;
import java.util.Arrays;
// 14.2
public class MergeSortedArrays {
  
  
  public static void main(String[] args) { 
    int a[] = new int[8];
    a[0] = 5;
    a[1] = 13;
    a[2] = 17;
    int b[] = { 3,7,11,19 };
    mergArrays(a, 3, b, 4);
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + ", ");
    }
  }
  
  public static void mergArrays(int[] a, int m, int[] b, int n) {
    int startIdx = (m - 1) + n;
    int i = m - 1;
    int j = n - 1;
    
    while (i >= 0 && j >= 0) {
      if (a[i] > b[j]) {
        a[startIdx] = a[i];
        i--;
      } else {
        a[startIdx] = b[j];
        j--;
      }
      startIdx--;
    }
    
    while (j >= 0) {
      a[startIdx] = b[j--];
      startIdx--;
    }
  }
  
}
