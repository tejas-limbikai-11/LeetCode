class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int n = pairs.length;
        int dp[][] = new int[n+1][n+1];
        for(int[] d: dp) Arrays.fill(d, -1);
        return solve(0, -1, pairs, dp);
    }

    public int solve(int idx, int prevIdx, int[][] pairs, int[][] dp) {
        if(idx >= pairs.length) return 0;

        if(prevIdx != -1 && dp[idx][prevIdx] != -1) {
            return dp[idx][prevIdx];
        }

        int take = 0;
        if(prevIdx == -1 || pairs[idx][0] > pairs[prevIdx][1]) {
            take = 1 + solve(idx + 1, idx, pairs, dp);
        }
        int skip = solve(idx + 1, prevIdx, pairs, dp);

        if(prevIdx != -1) {
            dp[idx][prevIdx] = Math.max(take, skip);
        }

        return Math.max(take, skip);
    }
}