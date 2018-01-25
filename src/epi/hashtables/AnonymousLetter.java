// 13.2
package epi.hashtables;
import java.util.HashMap;
import java.util.Map;

public class AnonymousLetter {
    public static void main(String args[]) {
        String letterText = "aabcccd";
        String magazineText = "aaajckcjcckcsjkbdbsjks";
        System.out.println(isLetterConstructable(letterText,magazineText ));
        
    }
    
    // O(m+n), O(L)
    public static boolean isLetterConstructable(String letter, String mag) {
        Map<Character, Integer> charFrequencies = new HashMap<>();
        
        for (char c : letter.toCharArray()) {
            if (charFrequencies.containsKey(c)) {
                charFrequencies.put(c, charFrequencies.get(c) + 1);
            } else {
                charFrequencies.put(c, 1);
            }
        }
        
        for (char c : mag.toCharArray()) {
            if (charFrequencies.containsKey(c)) {
                charFrequencies.put(c, charFrequencies.get(c) - 1);
                if (charFrequencies.get(c) == 0) {
                    charFrequencies.remove(c);
                    if (charFrequencies.isEmpty()) {
                        return true;
                    }
                }
            }
        }

        return charFrequencies.isEmpty();
    }
}
