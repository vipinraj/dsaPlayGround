package epi.dp;
import java.util.Arrays;

public class BinomialCoefficients {
    static int iter = 0;
    public static void main(String[] args) {
        int n = 45;
        int k = 3;
        Integer[][] dp = new Integer[n + 1][k + 1];
        System.out.println(calculate(n, k, dp));
        print(dp);

        System.out.println(calculateIter(n, k));
    }
    
    public static int calculate(int n, int k, Integer[][] dp) {
        System.out.println(++iter);
        if (n == k) {
            return 1;
        }
        
        if (k == 0) {
            return 1;
        }
        
        if (dp[n][k] == null) {
            dp[n][k] = calculate(n - 1, k - 1, dp) + calculate(n - 1, k, dp);
        }
        
        return dp[n][k];
    }

    public static int calculateIter(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        printArr(dp);
        return dp[n][k];
    }

	public static void print(Integer[][] arr) {
		System.out.println();
		for (int i = 0; i < arr.length; i++ ) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

    public static void printArr(int[][] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++ ) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
