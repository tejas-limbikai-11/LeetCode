class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int dp[][] = new int[n+1][n+1]; 
        for(int[] d: dp) Arrays.fill(d, -1);

        return solve(0, n-1, s, dp);
    }

    public int solve(int l, int r, String s, int[][] dp) {
        if(l == r) return 1;
        if(l > r) return 0;

        if(dp[l][r] != -1) {
            return dp[l][r];
        }

        int i = l+1;
        while(i < r && s.charAt(i) == s.charAt(l)) i++;

        if(i == r+1) return 1;

        int normal = 1 + solve(i, r, s, dp);

        int greedy = Integer.MAX_VALUE;

        for(int j=i; j<=r; j++) {
            if(s.charAt(j) == s.charAt(l)) {
                int x = solve(i, j-1, s, dp) + solve(j, r, s, dp);
                greedy = Math.min(greedy, x);
            }
        }

        return dp[l][r] = Math.min(normal, greedy);
    }
}