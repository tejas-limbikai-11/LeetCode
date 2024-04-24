class Solution {
    public int tribonacci(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return trib(n, dp);
    }

    public int trib(int n, int[] dp) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        if(dp[n] != -1) return dp[n];

        int tnmin1 = trib(n-1, dp);
        int tnmin2 = trib(n-2, dp);
        int tnmin3 = trib(n-3, dp);

        return dp[n] = tnmin1 + tnmin2 + tnmin3;
    }
}