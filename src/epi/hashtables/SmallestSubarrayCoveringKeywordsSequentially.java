// 13.8
package epi.hashtables;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class SmallestSubarrayCoveringKeywordsSequentially {
    public static void main(String args[]) {
        List<String> paragraph = new ArrayList<String>(Arrays.asList("apple", "bannana", "cat", "apple"));
        List<String> keywords = new ArrayList<String>(Arrays.asList( "bannana", "apple"));
        //System.out.println(getSmallestSubarray(paragraph,keywords ));
        keywords = new ArrayList<>(Arrays.asList("bannana", "cat"));
        paragraph = new ArrayList<>(Arrays.asList("apple", "bannana","bannana", "apple", "apple", "dog", "cat", 
                                                  "apple", "dog", "bannana", "bannana", "apple", "cat", "cat", "dog" ));
        System.out.println(getSmallestSubarray(paragraph,keywords ));
    }
    
    // my method
    public static Subarray getSmallestSubarray(List<String> paragraph, List<String> keywords) {
        Map<String, Integer> keywordsToCover = new HashMap<>();
        Map<String, Integer> tmpKeywordsToCover;
        Subarray result = new Subarray(-1, -1);

        for (String s: keywords) {
            keywordsToCover.put(s, 1);
        }
        tmpKeywordsToCover = new HashMap<>(keywordsToCover);
        
        int nextKeywordIdx = 0;
        Integer keywordsRemaining = keywords.size();
        
        for (int left = 0, right = 0; right < paragraph.size(); right++) {
           
            String word = paragraph.get(right);
            Integer keywordCount;
            if (word.equals(keywords.get(nextKeywordIdx))) {
                keywordCount = keywordsToCover.get(word);
                keywordsToCover.put(word, --keywordCount);
                if (keywordCount >= 0) {
                    keywordsRemaining--;                    
                }
                nextKeywordIdx++;
                
            } else if (nextKeywordIdx > 0 && word.equals(keywords.get(nextKeywordIdx - 1))) {
                keywordCount = keywordsToCover.get(word);
                keywordsToCover.put(word, --keywordCount);
            }
            
            while (keywordsRemaining == 0) {
                if ((result.start == -1 && result.end == -1) || right - left < result.end - result.start) {
                    result.start = left;
                    result.end = right;
                }
                System.out.println("Left: " + left + ", Right: " + right);
                word = paragraph.get(left);
                if (keywords.get(0).equals(word)) {
                    keywordCount = keywordsToCover.get(word);
                    System.out.println("keywordCount: " + keywordCount);
                    keywordsToCover.put(word, ++keywordCount);
                    if (keywordCount > 0) {
                        keywordsRemaining = keywords.size();
                        nextKeywordIdx = 0;
                        keywordsToCover = new HashMap<>(tmpKeywordsToCover);
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
