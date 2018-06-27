package epi.dp;

public class Traverse2DArray {
    public static int k = 0;
    public static void main(String[] args) {
        int rows = 5;
        int cols = 5;
        
        System.out.println(countNumberOfways(rows, cols));
    }
    
    public static int countNumberOfways(int rows, int cols) {
        Integer[][] dp = new Integer[rows + 1][cols + 1];
        return countNumberOfwaysHelper(rows, cols, 0, 0, dp);
    }
    
    public static int countNumberOfwaysHelper(int rows, int cols, int i, int j, Integer[][] dp) {
        
        System.out.println(++k);
        
        if (i == rows - 1 && j == cols - 1) {
            return 1;
        }
        
        if (dp[i][j] == null) {
            int right = j != cols ? countNumberOfwaysHelper(rows, cols, i, j + 1, dp) : 0;
            int down = i != rows ? countNumberOfwaysHelper(rows, cols, i + 1, j, dp) : 0;
            
            dp[i][j] =  right + down;   
        }
        
        return dp[i][j];
    }
}
