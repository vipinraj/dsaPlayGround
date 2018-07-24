package epi.dp;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Bedbathandbeyond {
    public static int counter = 0;
    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>(Arrays.asList(
            "i", "like", "sam", "sung", "samsung", "mobile", "ice", 
            "cream", "icecream", "man", "go", "mango"));
        Set<String> dictionary2 = new HashSet<>(Arrays.asList(
            "bed", "bath", "and", "be", "beyond", "on"));
        String input = "samsungandmangok";
        String input2 = "bedbathandbeyond";
        //System.out.println(checkIfDecomposable(dictionary, input, 0));
        System.out.println(checkIfDecomposable(dictionary2, input2, 0));
    }
    
    
    public static boolean checkIfDecomposable(Set<String> dictionary, String input, int indx) {
        System.out.println(++counter);
        if (indx == input.length()) {
            return true;
        }
        
        int tmIndx = indx;
        boolean found = false;
        while (tmIndx < input.length()) {
            tmIndx++;
            if (dictionary.contains(input.substring(indx, tmIndx))) {
                found = checkIfDecomposable(dictionary, input, tmIndx);;
                if (found) {
                    return true;
                }
            }
        }
        
        return false;
    }
}