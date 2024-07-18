class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(stones[i], i);
        }
        int dp[][] = new int[2001][2001];

        for(int d[]: dp) Arrays.fill(d, -1);
        return solve(stones, 0, 0, map, dp);
    }

    public boolean solve(int[] stones, int currStoneIdx, int prevJump, Map<Integer, Integer> map, int[][] dp) {
        int n = stones.length;
        if(currStoneIdx == n-1) return true;

        if(dp[currStoneIdx][prevJump] != -1) {
            return dp[currStoneIdx][prevJump] == 1;
        }

        boolean result = false;
        for(int nextJump = prevJump-1; nextJump<=prevJump+1; nextJump++) {
            if(nextJump > 0) {
                int nextStone = stones[currStoneIdx] + nextJump;
                
                if(map.containsKey(nextStone)) {
                    result = result || solve(stones, map.get(nextStone), nextJump, map, dp);
                }
            }
        }
        dp[currStoneIdx][prevJump] = (result ? 1 : 0);
        return result;
    }
}