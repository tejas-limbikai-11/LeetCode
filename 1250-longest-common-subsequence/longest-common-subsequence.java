class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] d: dp) Arrays.fill(d, -1);
        return solve(n, m, text1, text2, dp);
    }

    public int solve(int n, int m, String x, String y, int[][] dp) {
        if(n == 0 || m == 0) return 0;

        if(dp[n][m] != -1) {
            return dp[n][m];
        }

        if(x.charAt(n-1) == y.charAt(m-1)) {
            return dp[n][m] = 1 + solve(n-1, m-1, x, y, dp);
        }
        else {
            int case1 = solve(n, m-1, x, y, dp);
            int case2 = solve(n-1, m, x, y, dp);
            return dp[n][m] = Math.max(case1, case2);
        }
    }
}