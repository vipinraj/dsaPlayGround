package epi.dp;
import java.util.Arrays;

public class KnapSack {
	static int i = 0;
	public static void main(String[] args) {
		int[] weights = {5, 3, 4, 2};
		int[] values = {60, 50, 70, 30};
		int capacity = 5;

		System.out.println(getMaximumValue(weights, values, capacity));
	}

	public static int getMaximumValue(int[] weights, int[] values, int capacity) {

		int[][] dp = new int[values.length][capacity + 1];

		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}
	
		return getMaximumValueHelper(weights, values, capacity, 0, dp);		

	}

	public static int getMaximumValueHelper(int[] weights, int[] values, int capacity, int i, int dp[][]) {

		//System.out.println(++i);

		if (i >= weights.length) {
			return 0;
		}

		if (dp[i][capacity] == -1) {
			int withThisItem = getMaximumValueHelper(weights, values, capacity, i + 1, dp);
			int withoutThisItem = 0;
			if (capacity - weights[i] >= 0) {
				withoutThisItem = values[i] + getMaximumValueHelper(weights, values, capacity - weights[i] , i + 1, dp);
			}
			dp[i][capacity] = Math.max(withoutThisItem, withThisItem);
		}


		return dp[i][capacity];
	}
}