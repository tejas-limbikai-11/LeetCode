class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length; 

        int[][] dp = new int[m+1][n+1];
        for(int[] d: dp) Arrays.fill(d, -1);

        return solve(0, 0, grid, m, n, dp);
    }

    public int solve(int r, int c, int[][] grid, int m, int n, int[][] dp) {
        if(r == m-1 && c == n-1) return grid[r][c];

        if(dp[r][c] != -1) return dp[r][c];

        if(r == m-1) {        //can only go right
            return dp[r][c] = grid[r][c] + solve(r, c+1, grid, m, n, dp);
        }
        else if(c == n-1) {     //can only go down
            return dp[r][c] = grid[r][c] + solve(r+1, c, grid, m, n, dp);
        }
        else {
            int right = solve(r, c+1, grid, m, n, dp);
            int down = solve(r+1, c, grid, m, n, dp);
            return dp[r][c] = grid[r][c] + Math.min(down, right);
        }
    }
}