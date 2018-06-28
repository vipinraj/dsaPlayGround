package epi.dp;
public class SearchForSequenceIn2DArray {
	
	public static void main(String[] args) {
		int[][] arr = {
			{1, 2, 3},
			{3, 4, 5},
			{5, 6, 7}
		};

		int[] pattern = {1, 3, 4, 6};
		System.out.println(checkForPattern(arr, pattern));
		int[] pattern2 = {1, 2, 3, 4};
		System.out.println(checkForPattern(arr, pattern2));
		int[] pattern3 = {1, 2, 3, 5, 7, 6, 3};
		System.out.println(checkForPattern(arr, pattern3));
	}

	// not EPI, but same complexity, iterative
	public static boolean checkForPattern(int[][] arr, int[] pattern) {

		int dp[][] = new int[arr.length][arr[0].length];
		int[][] positions = {
			{-1, 0},
			{0, 1},
			{1, 0},
			{0, -1}
		};

		for (int p = 0; p < pattern.length; p++) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					if (p == 0) {
						if (arr[i][j] == pattern[0]) {
							dp[i][j] = 1;
							if (p == pattern.length - 1) {
								return true;
							}
						}
					} else {

						if (dp[i][j] == p) {
							for (int[] position : positions) {
								int iN = position[0] + i;
								int jN = position[1] + j;

								if (iN >= 0 && jN >= 0 && iN < arr.length && jN < arr[0].length) {
									if (arr[iN][jN] == pattern[p]) {
										dp[iN][jN] = p + 1;

										if (p == pattern.length - 1) {
											return true;
										}
									}
								}
							}
						}
					}
				}
			}
		}

		return false;
	}
}