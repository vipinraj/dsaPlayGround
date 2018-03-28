package epi.hashtables;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class StriingDecompostions {
  
  
  public static void main(String[] args) { 
    String s = "barfoothefoobarmanbarbarfoo";
    List<String> A = Arrays.asList("foo","bar","bar");
    System.out.println(getAllIndexes(s, A));
  }
  
  public static List<Integer> getAllIndexes(String s, List<String> words) {
    List<Integer> result = new ArrayList<Integer>();
    Map<String, Integer> wordFrequency = new HashMap<String, Integer>();
    
    for (String w : words) {
      if (wordFrequency.containsKey(w)) {
        wordFrequency.put(w, wordFrequency.get(w) + 1);
      } else {
        wordFrequency.put(w, 1);
      }
    }
    
    int wordLength = words.get(0).length();
    
    for (int i = 0; i <= s.length() - wordLength * words.size(); i++) {
      if (matchAllWordsInDict(s, i, wordFrequency, words.size(), wordLength)) {
        result.add(i);
      }
    }
    
    return result;
  }
  
  public static boolean matchAllWordsInDict(String s, int start, Map<String, Integer> dict, int noOfWords, int wordLen) {
    Map<String, Integer> currentDict = new HashMap<String, Integer>();
    
    for (int i = 0; i < noOfWords; i++) {
      String subStr = s.substring(start + (i * wordLen), start + (i * wordLen) + wordLen);
      Integer freq = dict.get(subStr);
      
      if (freq == null) {
        return false;
      }
      
      // insert frequency
      if (currentDict.containsKey(subStr)) {
        currentDict.put(subStr, currentDict.get(subStr) + 1);
      } else {
        currentDict.put(subStr, 1);
      }
      
      if (currentDict.get(subStr) > freq) {
        return false;
      }
    }
    return true;
  }
}