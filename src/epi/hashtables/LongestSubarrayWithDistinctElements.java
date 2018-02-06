// 13.9
package epi.hashtables;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class LongestSubarrayWithDistinctElements {
    public static void main(String args[]) {
        List<String> paragraph = new ArrayList<String>(Arrays.asList("f", "s", "f", "e", "t",
        "w", "e", "n", "w", "e"));
        System.out.println(getLongestMyMethod(paragraph));
        System.out.println(getLongestMethod2(paragraph));
        System.out.println(getLongestMyMethodImproved(paragraph));
    }
    
    // O(n) returns the Subarray start and position - not required in the question
    public static Subarray getLongestMyMethod(List<String> paragraph) {
        
        Subarray result = new Subarray(-1, -1);
        Map<String, Integer> distinctElements = new HashMap<>();
        int distinctSubarrStartIdx = 0;
        
        for (int i = 0; i < paragraph.size(); i++) {
            Integer idx = distinctElements.get(paragraph.get(i));
            
            if (idx == null) {
                distinctElements.put(paragraph.get(i), i);
                if (i == paragraph.size() - 1) {
                    if (result.end - result.start < i - distinctSubarrStartIdx) {
                        result.start = distinctSubarrStartIdx;
                        result.end = i;                        
                    }
                }
            } else {
                if (idx < distinctSubarrStartIdx) {
                    distinctElements.put(paragraph.get(i), i);
                    if (i == paragraph.size() - 1) {
                        if (result.end - result.start < i - distinctSubarrStartIdx) {
                            result.start = distinctSubarrStartIdx;
                            result.end = i;                        
                        }
                    }
                } else {
                    if (result.end - result.start < (i - 1) - distinctSubarrStartIdx) {
                        result.start = distinctSubarrStartIdx;
                        result.end = i - 1;                        
                    }
                    distinctSubarrStartIdx = idx + 1;
                }
            }
        }
        
        return result;
    }
    
    static class Subarray {
        int start;
        int end;
        
        Subarray(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public String toString() {
            return "Start: " + start + ", End: " + end;
        }
    }
    public static int getLongestMethod2(List<String> paragraph) {
        Map<String, Integer> latestOccurance = new HashMap<>();
        int distinctSubarrStartIdx = 0;
        int result = 0;
        
        for (int i = 0; i < paragraph.size(); i++) {
            Integer dupIdx = latestOccurance.put(paragraph.get(i), i);
            if (dupIdx != null) {
                if (dupIdx >= distinctSubarrStartIdx) {
                    result = Math.max(result, i - distinctSubarrStartIdx);
                    distinctSubarrStartIdx = dupIdx + 1;
                }
            }
        }
        result = Math.max(result, paragraph.size() - distinctSubarrStartIdx);
        return result;
    }
    
    public static Subarray getLongestMyMethodImproved(List<String> paragraph) {
        Map<String, Integer> latestOccurance = new HashMap<>();
        int distinctSubarrStartIdx = 0;

        Subarray result = new Subarray(-1, -1);
        for (int i = 0; i < paragraph.size(); i++) {
            Integer dupIdx = latestOccurance.put(paragraph.get(i), i);
            if (dupIdx != null) {
                if (dupIdx >= distinctSubarrStartIdx) {
                  if (result.start == -1 && result.end == -1 || result.end - result.start < i - distinctSubarrStartIdx) {
                    result.start = distinctSubarrStartIdx;
                    result.end = i - 1;
                  }
                  distinctSubarrStartIdx = dupIdx + 1;
                }
            }
        }
        
        if (result.end - result.start < paragraph.size() - distinctSubarrStartIdx) {
          result.start = distinctSubarrStartIdx;
          result.end = paragraph.size() - 1;
        }
     
        return result;
    }
}
