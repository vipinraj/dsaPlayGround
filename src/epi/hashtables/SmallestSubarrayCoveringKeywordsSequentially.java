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
        System.out.println(getSmallestSubarrayMethod2(paragraph,keywords ));
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
    
    // epi, O(n), O(m)
    public static Subarray getSmallestSubarrayMethod2(List<String> paragraph, List<String> keywords) {
      Map<String, Integer> keywordToIdx = new HashMap<>();
      List<Integer> latestOccurance = new ArrayList<Integer>(keywords.size());
      List<Integer> shortestSubArrayLength = new ArrayList<Integer>(keywords.size());
      
      for (int i = 0; i < keywords.size(); i++) {
        keywordToIdx.put(keywords.get(i), i);
        latestOccurance.add(-1);
        shortestSubArrayLength.add(Integer.MAX_VALUE);
      }
      
      int shortestDistance = Integer.MAX_VALUE;
      Subarray result = new Subarray(-1, -1);
      
      for (int i = 0; i < paragraph.size(); i++) {
        Integer keywordIdx = keywordToIdx.get(paragraph.get(i));
        
        if (keywordIdx != null) {
          if (keywordIdx == 0) { // first
            shortestSubArrayLength.set(0, 1);
          } else if (shortestSubArrayLength.get(keywordIdx - 1) != Integer.MAX_VALUE) {
            int distanceToPreviousKeyword = i - latestOccurance.get(keywordIdx - 1);
            shortestSubArrayLength.set(keywordIdx, distanceToPreviousKeyword + 
                                       shortestSubArrayLength.get(keywordIdx - 1));
          }
          latestOccurance.set(keywordIdx, i);
          
          
          if (keywordIdx == keywords.size() - 1 && shortestSubArrayLength.get( keywords.size() - 1) < shortestDistance) {
            shortestDistance = shortestSubArrayLength.get( keywords.size() - 1);
            result.start = i - shortestDistance + 1;
            result.end = i;
          } 
        }
      }
      return result;
    }
}
