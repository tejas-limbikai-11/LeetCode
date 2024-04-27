class Solution {
    public int findRotateSteps(String ring, String key) {
        int[][] dp = new int[101][101];
        for(int d[]: dp) Arrays.fill(d, -1);
        return solve(0, 0, ring, key, dp);
    }

    public int countSteps(int ringIdx, int i, int n) {
        int dist = Math.abs(i - ringIdx);
        int wrapAround = n - dist;
        return Math.min(dist, wrapAround);
    }

    public int solve(int ringIdx, int keyIdx, String ring, String key, int[][] dp) {
        if(keyIdx == key.length()) return 0;
        int result = Integer.MAX_VALUE;
        if(dp[ringIdx][keyIdx] != -1) return dp[ringIdx][keyIdx];

        for(int i=0; i<ring.length(); i++) {
            if(ring.charAt(i) == key.charAt(keyIdx)) {
                int steps = countSteps(ringIdx, i, ring.length());
                int totalSteps = 1 + steps + solve(i, keyIdx + 1, ring, key, dp); 
                result = Math.min(result, totalSteps);
            }
        }
        return dp[ringIdx][keyIdx] = result;
    }
}