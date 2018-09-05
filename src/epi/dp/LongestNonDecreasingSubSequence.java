package epi.dp;

public class LongestNonDecreasingSubSequence {
	public static void main(String[] args) {
		int[] arr = {0, 8, 8, 63, 7, 41, 96, 79, 95, 12, 84, 80, 57, 7, 54, 63, 65, 38, 57, 95, 89, 26, 46, 93, 55, 94, 51, 1, 22, 24, 89, 90, 37, 29, 52, 33, 15, 9, 37, 95, 41, 54, 45, 10, 40, 63, 67, 7, 53, 67, 25, 80, 94, 55, 0, 5, 38, 37, 46, 4, 34, 16, 20, 62, 66, 94, 91, 93, 24, 72, 76, 75, 80, 79, 64, 73, 65, 96, 0, 2, 66, 37, 83, 18, 21, 69, 89, 13, 73, 89, 4, 56, 24, 62, 0, 96};

		System.out.println(getLongestHelper(arr));
	}

	public static int getLongestHelper(int[] arr) {
		int[] dp = new int[arr.length];

		dp[0] = 1;

		for (int i = 1; i < arr.length; i++) {
			int longest = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] <= arr[i]) {
					longest = Math.max(longest, dp[j]);
				}
			}

			if (longest == 0) {
				longest = 1;
			} else {
				longest++;
			}

			dp[i] = longest;
		}

		int longest = 0;

		for (int i = 0; i < arr.length; i++) {
			longest = Math.max(longest, dp[i]);
		}

		return longest;
	}
}