package epi.hashtables;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class SmallestSubarrayCoveringKeywords {
    public static void main(String args[]) {
        List<String> keywords = new ArrayList<>(Arrays.asList("bannana", "cat"));
        List<String> paragraph = new ArrayList<>(Arrays.asList("apple", "bannana", "apple", "apple", "dog", "cat", "apple", "dog", "bannana", "apple", "cat", "dog", "bannana", "apple", "cat", "dog"));
    }
    
    public static Subarray getSmallestSubArray(List<String> paragraph, List<String> keywords) {
        
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
