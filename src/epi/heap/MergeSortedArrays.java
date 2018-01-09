/**
 * 11.1
 */
package epi.heap;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class MergeSortedArrays {
  
  public static void main(String[] args) { 
    List<List<Integer>> sortedArrays = new ArrayList<>();
    sortedArrays.add(new ArrayList<Integer>(Arrays.asList(3,5,7)));
    sortedArrays.add(new ArrayList<Integer>(Arrays.asList(0,6)));
    sortedArrays.add(new ArrayList<Integer>(Arrays.asList(0,6,28)));
    ArrayList<Integer> result = mergeSortedArrays(sortedArrays);
    System.out.println(result);
  }
  // O(nlogk), O(k) | k -> number of sorted arrays
  public static ArrayList<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays) {
    ArrayList<Integer> heads = new ArrayList<>(sortedArrays.size());
    ArrayList<Integer> result = new ArrayList<Integer>();
    
    // min heap
    PriorityQueue<HeapEntryWithSrcArrIdx> heap = new PriorityQueue<HeapEntryWithSrcArrIdx>(16, 
     new Comparator<HeapEntryWithSrcArrIdx>() {
      @Override
      public int compare(HeapEntryWithSrcArrIdx o1, HeapEntryWithSrcArrIdx o2) {
        return Integer.compare(o1.value, o2.value);
      }
     });
    
    for (int i = 0; i < sortedArrays.size(); i++) {
      if (sortedArrays.get(i).size() > 0) {
        HeapEntryWithSrcArrIdx entry = new HeapEntryWithSrcArrIdx(sortedArrays.get(i).get(0),i); 
        heap.add(entry);
        heads.add(1);
      } else {
        heads.add(0);
      }
    }
    
    HeapEntryWithSrcArrIdx rootEntry;
    while (!heap.isEmpty()) {
      rootEntry = heap.poll();
      result.add(rootEntry.value);
      int elemSrcArrIdx = rootEntry.srcArrIdx;
      int elemHeadIdx = heads.get(elemSrcArrIdx);
      
      if (sortedArrays.get(elemSrcArrIdx).size() > elemHeadIdx) {
        heap.add(new HeapEntryWithSrcArrIdx(sortedArrays.get(elemSrcArrIdx).get(elemHeadIdx), elemSrcArrIdx));
        heads.set(elemSrcArrIdx, elemHeadIdx + 1);
      }
    }
    
    return result;
  }
}

 class HeapEntryWithSrcArrIdx {
    Integer value;
    Integer srcArrIdx;
    
    HeapEntryWithSrcArrIdx(Integer value, Integer srcArrIdx) {
      this.value = value;
      this.srcArrIdx = srcArrIdx;
    }
  }
