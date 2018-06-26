package epi.dp;

import java.util.Arrays;

public class NumberOfScoreCombinations {
	static int count = 0;
	public static void main(String[] args) {
		int[] scores = {2, 3, 7, 8, 69, 9};
		int finalScore = 12;
		Integer[][] dp = new Integer[finalScore + 1][scores.length];
		System.out.println(countCombinations(scores, finalScore, 0, dp));
		System.out.println(countCombinationsDp1(scores, finalScore));
	}
	
	// recursive
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

	// dp - n^3 - inefficient
	public static int countCombinationsDp1(int[] scores, int targetScore) {
		int dp[][] = new int[scores.length][targetScore + 1];


		for (int i = 0; i <= targetScore; i++) {
			for (int j = 0; j < scores.length; j++) {
				int combinations = 0;
				for (int k = 0; i - k * scores[j] >= 0 && j != 0; k++ ) {
					combinations += dp[j - 1][i - k * scores[j]];
				}

				if (j == 0) {
					if (i >= scores[j] && i % scores[j] == 0) {
						combinations = 1;
					} else if (i == 0) {
						combinations = 1;
					}
				}

				dp[j][i] = combinations;
			}
		}
		print(dp);
		return dp[scores.length - 1][targetScore];
	}

	public static void print(int[][] arr) {
		System.out.println();
		for (int i = 0; i < arr.length; i++ ) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}