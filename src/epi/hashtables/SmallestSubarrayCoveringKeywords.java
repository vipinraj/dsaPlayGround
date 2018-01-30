package epi.hashtables;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class SmallestSubarrayCoveringKeywords {
    public static void main(String args[]) {
        List<String> keywords = new ArrayList<>(Arrays.asList("bannana", "cat"));
        List<String> paragraph = new ArrayList<>(Arrays.asList("apple", "bannana", "apple", "apple", "dog", "cat", "apple", "dog", "bannana", "apple", "cat", "dog", "bannana", "apple", "cat", "dog"));
    }
    
    public static Subarray getSmallestSubArray(List<String> paragraph, List<String> keywords) {
        Map<String, Integer> keywordMap = new HashMap<>();
        Map<Integer, Subarray> smallestsubArrMap = new HashMap<>();
        int subArrMinLen = keywords.size();
        
        for (String word : keywords) {
            keywordMap.put(word, 0);
        }
        
        int nextSubArrEnd =  subArrMinLen;
        for (int i = 0; i < paragraph.size(); i++) {
            int subArrMaxLen = paragraph.size() - i;
            
            while (nextSubArrEnd <= i) {
                
            }
        }
        return null;
    }
    
    static class Subarray {
        int start;
        int end;
        
        Subarray(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
