package epi.recursion;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MatchingParens {
	public static void main(String[] args) {
		int n = 3;
		System.out.println(getMatchingParens(n));
		List<String> result1 = getMatchingParens(4);
		List<String> result2 = getMatchingParens2(4);
		Collections.sort(result1);
		Collections.sort(result2);
		
		System.out.println(result1);
		System.out.println(result2);
	}
	
	// my method (produces different output)
	public static List<String> getMatchingParens(int n) {
		List<String> result = new ArrayList<>();
		getMatchingParensHelper(n, 1, "()", result, true);
		return result;
	}
	
	public static void getMatchingParensHelper(int n, int level, String currStr, List<String> result, boolean isSymmetric) {
		if ( n == level) {
			result.add(currStr);
			System.out.println(currStr + " : " + isSymmetric);
			return;
		}
		
		getMatchingParensHelper(n, level + 1, "(" + currStr + ")", result, false);
		getMatchingParensHelper(n, level + 1, "()" + currStr, result, isSymmetric && true);
		if (!(isSymmetric && true)) {
			getMatchingParensHelper(n, level + 1, currStr + "()" , result, false);
		}
	}
	
	// epi
	public static List<String> getMatchingParens2(int n) {
		List<String> result = new ArrayList<>();
		getMatchingParensHelper2(n, n, "", result);
		return result;
	}
	
	public static void getMatchingParensHelper2(int nofLeftParensNeeded, int nofRightParensNeeded, String validPrefix, List<String> result) {
		if ( nofLeftParensNeeded == 0 && nofRightParensNeeded == 0 ){
			result.add(validPrefix);
			return;
		}
		
		if (nofLeftParensNeeded > 0) {
			getMatchingParensHelper2(nofLeftParensNeeded - 1, nofRightParensNeeded, validPrefix + "(", result);
		}
		
		if ( nofLeftParensNeeded < nofRightParensNeeded ) {
			getMatchingParensHelper2(nofLeftParensNeeded, nofRightParensNeeded - 1, validPrefix + ")", result);
		}
	}
}