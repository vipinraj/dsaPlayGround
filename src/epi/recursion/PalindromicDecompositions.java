package epi.recursion;

import java.util.List;
import java.util.ArrayList;

public class PalindromicDecompositions {
	public static void main(String[] args) {
		System.out.println(getDecompositions("0204451881"));
	}
	
	public static List<List<String>> getDecompositions(String str) {
		List<List<String>> result = new ArrayList<>();
		getDecompositionsHelper(str, 0, new ArrayList<String>(), result, str.length());
		return result;
	}
	
	public static void getDecompositionsHelper(String string, int indx, List<String> decomposition,  List<List<String>> result, int len) {
		if (indx >= len) {
			result.add(new ArrayList<String>(decomposition));
			return;
		}
		
		for (int i = indx + 1; i <= string.length(); i++) {
			String prefix = string.substring(indx, i);
			if (isPalindrom(prefix)) {
				System.out.println(prefix);
				decomposition.add(prefix);
				getDecompositionsHelper(string, i, decomposition, result, len);
				decomposition.remove(decomposition.size() - 1);
			}
		}
	}
	
	public static boolean isPalindrom(String str) {
		
		int i = 0;
		int j = str.length() - 1;
		
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		
		return true;
	}
}
