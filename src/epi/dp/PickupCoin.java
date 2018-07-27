package epi.dp;

public class PickupCoin {
	public static int count = 0;
	public static void main(String[] args) {
		int[] coins = {25, 5, 10, 5, 10, 5, 10, 25, 1, 25, 1, 25, 1, 25, 5, 10};

		System.out.println(pickupForMaxGain(coins));
	}

	public static int pickupForMaxGain(int[] coins) {
		int dp[][] = new int[coins.length][coins.length];
		return pickupForMaxGainHelper(coins, 0, coins.length - 1, dp);
	}

	public static int pickupForMaxGainHelper(int[] coins, int a, int b, int[][] dp) {
		// System.out.println(++count);
		if (a > b) {
			return 0;
		}

		if (dp[a][b] == 0) {
			int maxWhenAisTaken = coins[a] + Math.min(pickupForMaxGainHelper(coins, a + 1, b - 1, dp),
			 						pickupForMaxGainHelper(coins, a + 2, b, dp));
			int maxWhenBisTaken = coins[b] + Math.min(pickupForMaxGainHelper(coins, a + 1, b - 1, dp),
			 						pickupForMaxGainHelper(coins, a, b - 2, dp));
			dp[a][b] = Math.max(maxWhenAisTaken, maxWhenBisTaken);
		}

		return dp[a][b];
	}

}