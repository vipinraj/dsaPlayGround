package epi.dp;
import java.util.Arrays;

public class NumberOfMovesToClimbStairs {
	static int c = 0;
	public static void main(String[] args) {
		int result = getNumberOfMoves(10, 3);
		System.out.println(result);
		System.out.println(c);
	}

	public static int getNumberOfMoves(int n, int k) {
		int[] dp = new int[n + 1];

		return getNumberOfMovesHelper(n, k, dp);
	}

	public static int getNumberOfMovesHelper(int n, int k, int[] dp) {
		++c;
		if (n == 0 || n == 1) {
			return 1;
		}

		if (dp[n] == 0) {
			int result = 0;
			for (int i = 1; i <= k && i <= n; i++) {
				result += getNumberOfMovesHelper(n - i, k, dp);
			}
			dp[n] = result;
		} 

		return dp[n];
	}
}