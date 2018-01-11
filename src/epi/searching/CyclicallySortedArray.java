// 12.3, variant nlogn
package epi.searching;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CyclicallySortedArray {
  
  
  public static void main(String[] args) { 
    List<Integer> input = new ArrayList<Integer>(Arrays.asList(378,478,550,631,103,203,220,234,279,368));
    int smallest = getSmallestElement(input, 0, input.size() - 1);
    System.out.println(input.get(smallest));
    smallest = getSmallestElementIterative(input);
    System.out.println(input.get(smallest));
    input = new ArrayList<Integer>(Arrays.asList(378,378,550,631,103,103,203,203,279,368));
    System.out.println(input.get(getSmallestElementInArrayWithDuplicates(input, 0, input.size() - 1)));
  }
  
  public static int getSmallestElement(List<Integer> arr, int l, int r) {
    if (l == r) {
      return l ;
    }
    
    int mid = ( r - l )/ 2 + l;
    if (arr.get(mid) < arr.get(r)) {
      return getSmallestElement(arr, l , mid);
    } else {
      return getSmallestElement(arr, mid+1, r);
    }
  }
  // O(n)
  public static int getSmallestElementInArrayWithDuplicates(List<Integer> arr, int l, int r) {
    if (l == r) {
      return l ;
    }
    
    int mid = ( r - l )/ 2 + l;
    
    if (arr.get(mid) < arr.get(r)) {
      return getSmallestElementInArrayWithDuplicates(arr, l , mid);
    } else if (arr.get(mid) > arr.get(r)) {
      return getSmallestElementInArrayWithDuplicates(arr, mid + 1, r);
    } else {
      // if arr.get(mid) == arr.get(r)
      
      int leftResult = getSmallestElementInArrayWithDuplicates(arr, l, mid);
      int rightResult = getSmallestElementInArrayWithDuplicates(arr, mid + 1, r);
      return arr.get(leftResult) < arr.get(rightResult) ? leftResult : rightResult;
    }
  }
  
  public static int getSmallestElementIterative(List<Integer> arr) {
    int l = 0;
    int r = arr.size() - 1;
    
    while (l < r) {
      int mid = l + (r - l) / 2;
      
      if (arr.get(mid) > arr.get(r)) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }
    
    return l;
  }
}
