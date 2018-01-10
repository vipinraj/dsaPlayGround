/**
 * 11.6
 */
package epi.heap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KLargestInMaxHeap {
  
  public static void main(String[] args) { 
    Integer[] maxHeap = new Integer[] {561,314,401,28,156,359,271,11,3};
    List<Integer> kLargest = getKLargestElemeents(maxHeap,4);
    System.out.println(kLargest);
  }
  
  // O(klogk), O(k)
  public static List<Integer> getKLargestElemeents(Integer[] maxHeapArr, int k) {
    PriorityQueue<HeapEntry> maxHeap = new PriorityQueue<>(k, new Comparator<HeapEntry>() {
      @Override
      public int compare(HeapEntry a, HeapEntry b) {
        return Integer.compare(b.value, a.value);
      }
    });
    List<Integer> result = new ArrayList<Integer>();
    maxHeap.add(new HeapEntry(0, maxHeapArr[0]));
    int counter = 0;
    
    while(counter < k) {
      HeapEntry e = maxHeap.poll();
      int i = e.index;
      result.add(e.value);
      if (i * 2 + 1 < maxHeapArr.length) {
        maxHeap.add(new HeapEntry(i * 2 + 1, maxHeapArr[i * 2 + 1]));
      }
      if (i * 2 + 2 < maxHeapArr.length) {
        maxHeap.add(new HeapEntry(i * 2 + 2, maxHeapArr[i * 2 + 2]));
      }
      counter++;
    }
    return result;
  }
  
}

class HeapEntry {
  Integer index;
  Integer value;
  HeapEntry(Integer index, Integer value) {
    this.index = index;
    this.value = value;
  }
}