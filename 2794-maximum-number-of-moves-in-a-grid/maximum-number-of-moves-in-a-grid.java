class Solution {
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        int count = 0;
        int[][] directions = {{-1, 1}, {0, 1}, {1, 1}};

        for(int c=m-1; c>=0; c--) {
            for(int r=0; r<n; r++) {

                for(int[] d: directions) {
                    int newR = r + d[0];
                    int newC = c + d[1];

                    if(newR >= 0 && newR < n && newC >= 0 && newC < m
                    && grid[newR][newC] > grid[r][c]) {
                        dp[r][c] = Math.max(dp[r][c], 1 + dp[newR][newC]);
                    }
                }

            }
        }

        for(int i=0; i<n; i++) {
            count = Math.max(count, dp[i][0]);
        }
        return count;
    }
}