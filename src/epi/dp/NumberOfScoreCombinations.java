package epi.dp;

import java.util.Arrays;

public class NumberOfScoreCombinations {
	static int count = 0;
	public static void main(String[] args) {
		int[] scores = {2, 3, 7, 8, 69, 9};
		int finalScore = 12;
		Integer[][] dp = new Integer[finalScore + 1][scores.length];
		System.out.println(countCombinations(scores, finalScore, 0, dp));
	}
	
	public static int countCombinations(int[] scores, int targetScore, int i, Integer[][] dp) {
		
		if (targetScore == 0) {
			return 1;
		}
		
		if (i >= scores.length) {
			return 0;
		}
		
		if (targetScore < 0) {
			return 0;
		}
		System.out.println(++count);
		
		if (dp[targetScore][i] == null) {
			dp[targetScore][i] = countCombinations(scores, targetScore - scores[i], i, dp) + 
				countCombinations(scores, targetScore, i + 1, dp);
		}
		
		return dp[targetScore][i];
	}
}