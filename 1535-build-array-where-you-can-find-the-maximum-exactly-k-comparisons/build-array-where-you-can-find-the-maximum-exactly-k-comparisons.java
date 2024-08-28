class Solution {
    int mod = 1_000_000_007;

    public int numOfArrays(int n, int m, int k) {
        int[][][] dp = new int[51][51][101];
        for(int[][] dp_2d: dp) {
            for(int[] d: dp_2d) Arrays.fill(d, -1);
        }

        return solve(0, 0, 0, n, m, k, dp);
    }

    public int solve(int idx, int searchCost, int maxSoFar, int n, int m, int k, int[][][] dp) {
        if(idx == n) {
            if(searchCost == k) return 1;
            else return 0;
        }

        if(dp[idx][searchCost][maxSoFar] != -1) {
            return dp[idx][searchCost][maxSoFar];
        }

        int result = 0;

        for(int i=1; i<=m; i++) {
            if(i > maxSoFar) {
                result = (result + solve(idx + 1, searchCost + 1, i, n, m, k, dp)) % mod;
            }
            else result = (result + solve(idx + 1, searchCost, maxSoFar, n, m, k, dp)) % mod;
        }
        
        return dp[idx][searchCost][maxSoFar] = result % mod;
    }
}