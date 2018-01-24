/**
 * Auto Generated Java Class.
 */
package epi.hashtables;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class Anagrams {
  
  public static void main(String[] args) { 
    List<String> words = new ArrayList<>(
       Arrays.asList("debitcard", "elvis", "silent", "badcredit", "lives", "freedom", "listen", "levis", "money")
    );
    
    Map<String, List<String>> groups = getAnagramGroups(words);
    
    for (String k : groups.keySet()) {
      if (groups.get(k).size() > 1) {
        System.out.println(groups.get(k));
      }
    }
  }
  
  public static Map<String, List<String>> getAnagramGroups(List<String> a) {
    Map<String, List<String>> groups = new HashMap<>();
    
    for (String s : a) {
      char[] sCharArr = s.toCharArray();
      Arrays.sort(sCharArr);
      String sSortedString = new String(sCharArr);
      if (groups.get(sSortedString) != null) {
        List<String> words = groups.get(sSortedString);
        words.add(s);
      } else {
        groups.put(sSortedString, new ArrayList<String>(Arrays.asList(s)));
      }
    }
    
    return groups;
  }
  
}
