import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
// get number of coins to make a sum
class CoinChangeMinimum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a[] = new int[m];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        //System.out.println(solveRec(a, n));
        System.out.println(solveDP(a, n));
    }
    
    public static long solveRec(int[] a, int n) {
        return solveRecHelper(a, n, 0, 0);
    }
    
    public static long solveRecHelper(int[] a, int n, int i, int coins) {
        if (n == 0) {
            return coins;
        }
        
        if (n < 0) {
            return Long.MAX_VALUE;
        }
        
        if (i >= a.length) {
            return Long.MAX_VALUE;
        }
        
        return Math.min(solveRecHelper(a, n - a[i], i, coins + 1), solveRecHelper(a, n, i + 1, coins));
    }
    
    public static long solveDP(int[] a, int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        
        for (int coin = 0; coin < a.length; coin++) {
            for (int i = 1; i < n + 1; i++) {
                if (a[coin] <= i) {
                    long result = dp[i - a[coin]];

                    if (result != Long.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], result + 1);
                    }
                }
            }
            print(dp);
        }
        
        return dp[n];
    }
    
    public static void print(long[] a) {
        for(int i = 0; i < a.length; i++) {
            if (a[i] == Long.MAX_VALUE) {
              System.out.print("inf ");
              continue;
            }
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
