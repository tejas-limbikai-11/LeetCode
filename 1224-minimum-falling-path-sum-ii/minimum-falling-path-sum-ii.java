class Solution {
    public int minFallingPathSum(int[][] grid) {
        int dp[][] = new int[201][201];
        for(int d[]: dp) Arrays.fill(d, -1);

        int n = grid.length;
        int result = Integer.MAX_VALUE;
       
        for(int col=0; col<n; col++) {
            result = Math.min(result, solve(0, col, grid, dp));
        }
        return result;
    }

    public int solve(int row, int col, int[][] grid, int[][] dp) {
        int n = grid.length;
        int ans = Integer.MAX_VALUE;

        if(row == n-1) return grid[row][col];
        if(dp[row][col] != -1) return dp[row][col];

        for(int nextCol = 0; nextCol < n; nextCol++) {
            if(nextCol != col) {
                ans = Math.min(ans, solve(row+1, nextCol, grid, dp));
            }
        }
        return dp[row][col] = ans + grid[row][col];
    }
}