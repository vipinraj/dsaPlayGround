package epi.hashtables;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class CollatzConjucture {
  
  
  public static void main(String[] args) { 
    int n = 999999;
   // System.out.println(test(n));
    System.out.println(test2(n));
  }
  
  public static boolean test(int n) {
    Set<Integer> verifiedNumbers = new HashSet<>();
    
    for (int i = 1; i <= n; i++) {
      if (verifiedNumbers.contains(i)) {
        continue;
      }
      
      int tempN = i;
      List<Integer> intermediateNs = new ArrayList<Integer>();

      while (tempN != 1) {
        if (tempN % 2 != 0) {
          tempN = tempN * 3 + 1;
        } else {
          tempN = tempN / 2;
        }
        if (!intermediateNs.add(tempN)) {
          return false;
        }
        if (verifiedNumbers.contains(tempN)) {
          for (Integer k : intermediateNs) {
            verifiedNumbers.add(k);
          }
          break;
        }
      }
    }
    return true;
  }
  
  // epi
  public static boolean test2(int n) {
    Set<Long> verifiedNumbers = new HashSet<Long>();
    
    for (int i = 3; i <= n; i += 2) {
      Set<Long> sequence = new HashSet<Long>();
      long testI = i;
      
      while(testI >= i) {
        if (!sequence.add(testI)) {
          return false;
        }
        if (testI % 2 == 0) {
          testI = testI / 2;
        } else {
          
          if (!verifiedNumbers.add(testI)) {
            break;
          }
          
          long nextTestI = testI * 3 + 1;
          // check overflow
          if (nextTestI < testI) {
            throw new ArithmeticException("Collatz sequence overflow for " + i);
          }
          testI = nextTestI;
        }
      }
    }
    return true;
  }
}
