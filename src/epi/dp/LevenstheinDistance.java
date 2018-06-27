package epi.dp;
import java.util.Arrays;

public class LevenstheinDistance {
    public static int i = 0;
    public static void main(String[] args) {
        String s1 = "Saturday";
        String s2 = "Sundays";
        
        System.out.println(getDistance(s1, s2));
    }
    
    public static int getDistance(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return getDistanceHelper(s1, s2, s1.length() - 1, s2.length() - 1, dp);        
    }
    
    public static int getDistanceHelper(String s1, String s2, int s1_indx, int s2_indx, int dp[][]) {
        if (s2_indx < 0) {
            return s1_indx + 1;           
        }
        
        if (s1_indx < 0) {
            return s2_indx + 1;
        }
        System.out.println(++i);
        
        if (dp[s1_indx][s2_indx] == -1) {
            if (s1.charAt(s1_indx) == s2.charAt(s2_indx)) {
                dp[s1_indx][s2_indx] = getDistanceHelper(s1, s2, s1_indx -1, s2_indx - 1, dp);
            } else {
                dp[s1_indx][s2_indx] =  1 + Math.min(
                        getDistanceHelper(s1, s2, s1_indx, s2_indx - 1, dp),
                        Math.min(getDistanceHelper(s1, s2, s1_indx - 1, s2_indx, dp),
                                    getDistanceHelper(s1, s2, s1_indx - 1, s2_indx - 1, dp)
                                    )
                        );
            }

        }
        
        return dp[s1_indx][s2_indx];
    }
}
