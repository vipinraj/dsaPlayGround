package epi.dp;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Bedbathandbeyond {
    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>(Arrays.asList(
            "i", "like", "sam", "sung", "samsung", "mobile", "ice", 
            "cream", "icecream", "man", "go", "mango"));
        String input = "samsungandmangok";
        System.out.println(checkIfDecomposable(dictionary, input, 0));
    }
    
    
    public static boolean checkIfDecomposable(Set<String> dictionary, String input, int indx) {
        if (indx == input.length()) {
            return true;
        }
        
        int tmIndx = indx;
        boolean found = false;
        while (tmIndx < input.length()) {
            tmIndx++;
            if (dictionary.contains(input.substring(indx, tmIndx))) {
                found = true;
                break;
            }
        }
        
        if (found) {
            return checkIfDecomposable(dictionary, input, tmIndx);
        } else {
            return false;
        }
    }
}