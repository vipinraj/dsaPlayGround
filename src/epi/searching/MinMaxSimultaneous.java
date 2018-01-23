/**
 * 12.7
 */
package epi.searching;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class MinMaxSimultaneous {
  
  
  public static void main(String[] args) { 
    List<Integer> nums = new ArrayList<>(Arrays.asList(7,2,5,6,1,2,9,8,0));
    MinMax minMax = getMinAndMax(nums);
    System.out.println(minMax);
    nums = new ArrayList<>(Arrays.asList(7));
    minMax = getMinAndMax(nums);
    System.out.println(minMax);
    nums = new ArrayList<>(Arrays.asList(7,2,5,6,1,2,9,8));
    minMax = getMinAndMax(nums);
    System.out.println(minMax);
    nums = new ArrayList<>(Arrays.asList(7,2));
    minMax = getMinAndMax(nums);
    System.out.println(minMax);
  }
  
  // based on CLRS, 3[n/2] comparisons
  public static MinMax getMinAndMax(List<Integer> a) {
    if (a.size() == 1) {
      return new MinMax(a.get(0), a.get(0));
    }
    
    int min;
    int max;
    int startIdx;
    
    if (a.size() % 2 == 0) {
      if (a.get(0) > a.get(1)) {
        min = a.get(1);
        max = a.get(0);
      } else {
        min = a.get(0);
        max = a.get(1);      
      }
      
      if (a.size() == 2) {
        return new MinMax(min, max);
      }
      startIdx = 2;
    } else {
      min = a.get(0);
      max = a.get(0);
      startIdx = 1;
    }
    
    int localMin;
    int localMax;
    
    for (int i = startIdx; i < a.size(); i += 2) {
      if (a.get(i) > a.get(i+1)) {
        localMax = a.get(i);
        localMin = a.get(i+1);
      } else {
        localMax = a.get(i+1);
        localMin = a.get(i);
      }
      
      if (localMax > max) {
        max = localMax;
      }
      
      if (localMin < min) {
        min = localMin;
      }
    }
    
    return new MinMax(min, max);
    
  }
  
  
}

class MinMax {
  int min;
  int max;
  MinMax(int min, int max) {
    this.min = min;
    this.max = max;
  }
  @Override
  public String toString() {
    return "Min: " + this.min + ", Max: " + this.max;
  }
}
