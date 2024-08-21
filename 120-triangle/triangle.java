class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] d: dp) Arrays.fill(d, -1);

        return solve(0, 0, triangle, dp);
    }

    public int solve(int r, int c, List<List<Integer>> triangle, int[][] dp) {
        if(r >= triangle.size()) return 0;

        if(dp[r][c] != -1) return dp[r][c];

        int opt1 = solve(r+1, c, triangle, dp);
        int opt2 = solve(r+1, c+1, triangle, dp);

        return dp[r][c] = triangle.get(r).get(c) + Math.min(opt1, opt2);
    }
}