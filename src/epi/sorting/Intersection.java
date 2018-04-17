/**
 * 14.1
 */
package sorting;
import java.util.List;
import java.util.ArrayList;

public class Intersection {
  
  public static void main(String[] args) { 
    int[] a = { 2,3,3,5,5,6,7,7,8,12 };
    int[] b = { 5,5,6,8,8,9,10,10 };
    List<Integer> intersection = getIntersection(a, b);
    System.out.println(intersection);
  }
  
  public static List<Integer> getIntersection(int[] a, int[] b) {
    Integer lastAddedE = null;
    List<Integer> result = new ArrayList<Integer>();
    int i1 = 0;
    int i2 = 0;
    
    while (i1 < a.length && i2 < b.length) {
      int aE = a[i1];
      int bE = b[i2];
      
      if (aE == bE) {
        if (lastAddedE == null || (aE != lastAddedE)) {
          result.add(aE);
          lastAddedE = aE;
        }
        i1++;
        i2++;
      } else if (aE < bE) {
        i1++;
      } else {
        i2++;
      }
    }
    return result;
  }
  
}
