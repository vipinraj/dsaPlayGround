/**
 * 12.9
 */
package epi.searching;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;

public class MissingIPAddress {
  
  
  public static void main(String[] args) { 
    int n = 990000;
    Random r = new Random();
    
    Set<Integer> hash = new HashSet<>();
    List<Integer> sequence = new ArrayList<>();
    
    for (int i = 0; i < n; ++i) {
      int x;
      do {
        x = r.nextInt(1000000);
      } while (!hash.add(x));
      sequence.add(x);
    }

    int missing = getMissingIp(sequence);
    assert(!hash.contains(missing));
    System.out.println(!hash.contains(missing));
    System.out.println(missing);
    
    int missingIp = getMissingIp(sequence);
  }
  
  public static int getMissingIp(Iterable<Integer> ipSeq) {
    int num_bucket = 1 << 16; // 2^16
    int[] counter = new int[num_bucket];
    Iterator<Integer> iter = ipSeq.iterator();
      
    while (iter.hasNext()) {
      int ip = iter.next();
      counter[ip>>>16]++;
    }
    
    for (int i = 0; i < num_bucket; i++) {
      if (counter[i] < num_bucket) {
        // get all ips starting with this i
        BitSet bitVect = new BitSet(num_bucket);
        iter = ipSeq.iterator();
        while (iter.hasNext()) {
          int ip = iter.next();
          if (ip>>>16 == i) {
            //get lower 16 bits and set
            bitVect.set((num_bucket-1) & ip);
          }
        }
        // get the first unset bit from bitVect
        for(int j = 0; j < num_bucket; j++) {
          if (!bitVect.get(j)) {
            return i << 16 | j;
          }
        }
      }
    }
    return -1;
  }
  
  /* ADD YOUR CODE HERE */
  
}

