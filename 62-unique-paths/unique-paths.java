class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[n][m];
        for(int d[]: dp) {
            Arrays.fill(d, -1);
        }

        return uniquePathsTabulation(0, 0, n, m, dp);
    }

    public static int uniquePathsTabulation(int i, int j, int n, int m, int dp[][]) {
        if(i == n-1 && j == m-1) return dp[i][j] = 1;
        for(i=n-1; i>=0; i--) {
            for(j=m-1; j>=0; j--) {

                if(i == n-1 && j == m-1) {
                    dp[i][j] = 1;
                    continue;
                }

                int downPaths = 0;
                int rightPaths = 0;

                if(i+1 < n) {
                    downPaths = dp[i+1][j];
                }

                if(j+1 < m) {
                    rightPaths = dp[i][j+1];
                }

                int totalPaths = rightPaths + downPaths;
                dp[i][j] = totalPaths;
            }
        }
        return dp[0][0];
    }

    // public static int uniquePathsMemoization(int i, int j, int n, int m, int dp[][]) {
    //     if(i == n-1 && j == m-1) return dp[i][j] = 1;

    //     int downPaths = 0;
    //     int rightPaths = 0;

    //     if(dp[i][j] != -1) {
    //         return dp[i][j];
    //     }

    //     if(i+1 < n) {
    //         downPaths = uniquePathsMemoization(i+1, j, n, m, dp);
    //     }

    //     if(j+1 < m) {
    //         rightPaths = uniquePathsMemoization(i, j+1, n, m, dp);
    //     }

    //     int totalPaths = rightPaths + downPaths;
    //     return dp[i][j] = totalPaths;
    // }
}