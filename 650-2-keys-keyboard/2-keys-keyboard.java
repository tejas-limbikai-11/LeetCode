class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        int dp[][] = new int[1001][1001];
        for(int[] d: dp) Arrays.fill(d, -1);
        return 1 + solve(1, 1, n, dp);
    }

    public int solve(int currA, int clipboard, int n, int[][] dp) {
        if(currA == n) return 0;
        if(currA > n) return 1000;

        if(dp[currA][clipboard] != -1) {
            return dp[currA][clipboard];
        }

        int copyAllpaste = 1 + 1 + solve(currA * 2, currA, n, dp);
        int paste = 1 + solve(currA + clipboard, clipboard, n, dp);

        return Math.min(copyAllpaste, paste);
    }
}