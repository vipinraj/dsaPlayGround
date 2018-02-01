// 13.7, variants
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
        List<String> paragraph = new ArrayList<>(Arrays.asList("apple", "bannana", "apple", "apple", "dog", "cat", "apple", "dog", "bannana", "apple", "cat", "dog" ));
        System.out.println(getSmallestSubArray(paragraph,keywords ));
        System.out.println();
        System.out.println(getSmallestSubArray2(paragraph,keywords ));
    }
    
    // my method; not O(n)
    public static Subarray getSmallestSubArray(List<String> paragraph, List<String> keywords) {
        Set<String> keywordMap = new HashSet<>();
        Set<String> keywordMapTmp;
        int subArrMinLen = keywords.size() - 1;
        Subarray result = new Subarray(-1,-1);
        for (String word : keywords) {
            keywordMap.add(word);
        }
        
        for (int i = 0; i < paragraph.size(); i++) {
            keywordMapTmp = new HashSet<>(keywordMap);
            int right;
            if (result.start == -1 && result.end == -1) {
                right = i + subArrMinLen;
            } else  {
                right = result.end > i ? result.end > i + subArrMinLen ? result.end :  i + subArrMinLen :  i + subArrMinLen;
            }
            
            right = i;
    
            while (!keywordMapTmp.isEmpty() && right < paragraph.size()) {
                keywordMapTmp.remove(paragraph.get(right));
                System.out.println("Left: " + i + " right: " + right);
                right ++;
            }
            
            if (keywordMapTmp.isEmpty()) {
                right --;
                if ((result.end == -1 && result.start == -1) || right - i <= result.end - result.start) {
                    result.start = i;
                    result.end = right;
                }
            }
        }
        return result;
    }
    
    // epi, sliding window, O(n) (https://stackoverflow.com/a/5447601)
    public static Subarray getSmallestSubArray2(List<String> paragraph, List<String> keywords) {
        Map<String, Integer> keywordsToCover = new HashMap<>();
        Subarray result = new Subarray(-1, -1);
        for (String s: keywords) {
            keywordsToCover.put(s, keywordsToCover.containsKey(s) ? keywordsToCover.get(s) + 1 : 1);
        }
        
        Integer itemsRemaining = keywords.size();
        
        for (int left = 0, right = 0; right < paragraph.size(); right++) {
            Integer keywordCount = keywordsToCover.get(paragraph.get(right));
            if (keywordCount != null) {
                keywordsToCover.put(paragraph.get(right), --keywordCount);
                if (keywordCount >= 0) {
                    itemsRemaining--;   
                }
            }
            System.out.println("Left: " + left + " right: " + right);
            
            while (itemsRemaining == 0) {
                System.out.println("--Left: " + left + " right: " + right);
                if ((result.start == -1 && result.end == -1 ) || right - left < result.end - result.start ) {
                    result.start = left;
                    result.end = right;
                }
                
                keywordCount = keywordsToCover.get(paragraph.get(left));
                if (keywordCount != null) {
                    keywordsToCover.put(paragraph.get(left), ++keywordCount);
                    if (keywordCount > 0) {
                        itemsRemaining++;   
                    }
                }
                left++;
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
}
