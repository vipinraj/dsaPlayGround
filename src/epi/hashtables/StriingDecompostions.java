package epi.hashtables;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class StriingDecompostions {
  
  
  public static void main(String[] args) { 
    String s = "barfoothefoobarman";
    List<String> A = Arrays.asList("foo", "bar");
  }
  
  public static List<Integer> getAllIndexes(String s, List<String> words) {
    int wordLen = words.get(0).length;
    Map<String, List<Integer>> wordToIdx = new HashMap<>();
    
    for (int i = 0; i <= s.length - wordLen; i++) {
      
      if (wordToIdx.containsKey(s.substring(i, i + wordLen + 1))) {
        wordToIdx.put(s.substring(i, i + wordLen + 1), wordToIdx.get(s.substring(i, i + wordLen + 1)).add(i));
      } else {
        List<Integer> indexes = Arrays.asList(i);
        wordToIdx.put(s.substring(i, i + wordLen + 1), indexes);
      }
    }
    
    Set<String> words = new HashSet<>();
    
    for (String str : words) {
      words.add(str);
    }
    
    for (String str : words) {
     Set<String> wordsCopy = new  HashSet<>(words);
     List<Integer> indexes = wordToIdx.get(str);
     
     if (indexes != null) {
       wordsCopy.remove(str);
       
       for (Integer i : indexes) {
         if () {
         
         }
       }
     }
     
    }
    
  }
  
}
abcde
   3 4   