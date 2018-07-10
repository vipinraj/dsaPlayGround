package epi.dp;

public class MinimumWeightPathInTriangle {
    public static void main(String[] args) {
        int[][] triangle = {
            {2, -1, -1, -1, -1},
            {4, 4, -1, -1, -1},
            {8, 5, 6, -1, -1},
            {4, 2, 6, 2, -1},
            {1, 5, 2, 3, 4}
        };
        
        System.out.println(getLeastWeightPath(triangle));
        
    }
    
    public static int getLeastWeightPath(int[][] triangle) {
        int[] dp = new int[triangle.length];
               
        dp[0] = triangle[0][0];
        //print(dp);
        for (int i = 1; i < triangle.length; i++) {
            int[] dpTemp = new int[triangle.length];
            for (int j = 0; j < i + 1; j++) {
                int n1 = Integer.MAX_VALUE;
                int n2 = Integer.MAX_VALUE;
                
                if (j != i) {
                    n1 = dp[j];
                }

                if (j - 1 >= 0) {
                    n2 = dp[j - 1];
                }

                if (n1 != Integer.MAX_VALUE && n2 != Integer.MAX_VALUE) {
                    dpTemp[j] = Math.min(triangle[i][j] + n1, triangle[i][j] + n2);
                } else if (n1 != Integer.MAX_VALUE) {
                    dpTemp[j] = triangle[i][j] + n1;
                } else if (n2 != Integer.MAX_VALUE) {
                    dpTemp[j] = triangle[i][j] + n2;
                }
            }
            dp = dpTemp;
            //print(dp);
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            min = Math.min(min, dp[i]);
        }

        return min;
    }
    
    public static void print(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
