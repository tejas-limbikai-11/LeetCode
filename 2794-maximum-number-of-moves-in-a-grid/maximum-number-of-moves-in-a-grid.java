class Solution {
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] d: dp) Arrays.fill(d, -1);
        int count = 0;

        for(int i=0; i<n; i++) {
            count = Math.max(count, solve(i, 0, grid, dp));
        }
        return count;
    }

    public int solve(int r, int c, int[][] grid, int[][] dp) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 0;
        }

        if(dp[r][c] != -1) {
            return dp[r][c];
        }

        int[][] directions = {{-1, 1}, {0, 1}, {1, 1}};
        int take = 0;

        for(int[] d: directions) {
            int newR = r + d[0];
            int newC = c + d[1];

            if(newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length
            && grid[newR][newC] > grid[r][c]) {
                take = Math.max(take, 1 + solve(newR, newC, grid, dp));
            }
        }
        
        return dp[r][c] = take;
    }
}