class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();

        int[][] dp = new int[101][101];
        for(int d[]: dp) Arrays.fill(d, Integer.MAX_VALUE);
        
        for(int ringIdx = 0; ringIdx < n; ringIdx++) {
            dp[ringIdx][m] = 0;
        }

        for(int keyIdx = m-1; keyIdx >= 0; keyIdx--) {
            for(int ringIdx = 0; ringIdx < n; ringIdx++) {
                int result = Integer.MAX_VALUE;
                for(int i=0; i<ring.length(); i++) {
                    if(ring.charAt(i) == key.charAt(keyIdx)) {
                        int steps = countSteps(ringIdx, i, ring.length());
                        int totalSteps = 1 + steps + dp[i][keyIdx + 1]; 
                        result = Math.min(result, totalSteps);
                    }
                }
                dp[ringIdx][keyIdx] = result;
            } 
        }
        return dp[0][0];
    }

    public int countSteps(int ringIdx, int i, int n) {
        int dist = Math.abs(i - ringIdx);
        int wrapAround = n - dist;
        return Math.min(dist, wrapAround);
    }
}