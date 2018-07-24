package epi.dp;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Bedbathandbeyond {
    public static int counter = 0;
    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>(Arrays.asList(
            "i", "like", "sam", "sung", "samsung", "mobile", "ice", 
            "cream", "icecream", "man", "go", "mango"));
        String input = "ilikelikeimangoiii";
        Set<String> dictionary2 = new HashSet<>(Arrays.asList(
            "bed", "bath", "and", "be", "beyond", "on"));
        String input2 = "samsungandmangok";
        String input3 = "bedbathandbeyond";
        //System.out.println(checkIfDecomposable(dictionary, input, 0));
        System.out.println(checkIfDecomposable(dictionary2, input2, 0));
        System.out.println(checkIfDecomposable(dictionary, input, 0));
        System.out.println(getDecomposition(dictionary, input));
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

    public static List<String> getDecomposition(Set<String> dictionary, String input) {
    	int [] lastLength = new int[input.length()];
    	Arrays.fill(lastLength, -1);

    	for (int i = 0; i < input.length(); i++) {
    		if (dictionary.contains(input.substring(0, i + 1))) {
    			lastLength[i] = i + 1;
    		}

    		if (lastLength[i] == -1) {

    			for (int j = 0; j < i; j++) {
    				if (lastLength[j] != -1 && dictionary.contains(input.substring(j + 1, i + 1))) {
    					lastLength[i] = i - j;
    					break;
    				}
    			}
    		}
    	}

    	for (int i = 0; i < input.length(); i++) {
    		//System.out.print(lastLength[i] + " ");
    	}

    	List<String> output = new ArrayList<>();

    	if (lastLength[input.length() - 1] != -1) {
	    	

    		int indx = input.length() - 1;

	    	while (indx >= 0) {
	    		
    			output.add(input.substring(indx - lastLength[indx] + 1, indx + 1));
    			indx = indx - lastLength[indx];
    		
	    	}
	    	Collections.reverse(output);
    	}

    	return output;
    }
}