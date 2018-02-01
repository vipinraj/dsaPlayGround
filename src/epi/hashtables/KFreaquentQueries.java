package epi.hashtables;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Comparator;

public class KFreaquentQueries {
    public static void main(String args[]) {
        
    }
    
    public List<String> kFrequentQueries(List<String> list, int k) {
       Map<String, Integer> frequencies = new HashMap<>();
       MinHeap minHeap = new MinHeap(k);
       for (String s: list) {
           if (frequencies.containsKey(s)) {
               frequencies.put(s, frequencies.get(s) + 1);
           } else {
               frequencies.put(s, 1);
           }
           
           if (minHeap.size() < k) {
               //minHeap.insert(frequencies.);
           }
       }
       return null;
    }
    
    static class MinHeap {
        PriorityQueue<Map.Entry<String, Integer>> minHeap;
        int capacity;
        
        MinHeap(int size) {
            this.capacity = size;
            minHeap = new PriorityQueue<Map.Entry<String, Integer>>(size, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b){
                    return Integer.compare(b.getValue(), a.getValue());
                }
            });
        }
        
        public Map.Entry<String, Integer> insert(Map.Entry<String, Integer> e) {
            Map.Entry<String, Integer> polled = null;
            if (minHeap.size() >= capacity) {
                polled = minHeap.poll();
            }
            minHeap.add(e);
            
            return polled != null ? polled : null;
        }
        
        public Map.Entry<String, Integer> poll() {
            return minHeap.poll();
        }
        
        public Map.Entry<String, Integer> peek() {
            return minHeap.peek();
        }
        
        public int size() {
            return minHeap.size();
        }
    }
}
