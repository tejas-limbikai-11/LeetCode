class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int result = 0;
        int[][] visited = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid2[i][j] == 1) {
                    if(dfs(i, j, grid1, grid2)) result++;
                }
            }
        }

        return result;
    }

    public boolean dfs(int i, int j, int[][] grid1, int[][] grid2) {
        if(i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length || grid2[i][j] != 1) {
            return true;
        }

        grid2[i][j] = -1;

        boolean isSubIsland = grid1[i][j] == 1; 

        boolean up = dfs(i - 1, j, grid1, grid2);
        boolean down = dfs(i + 1, j, grid1, grid2);
        boolean left = dfs(i, j - 1, grid1, grid2);
        boolean right = dfs(i, j + 1, grid1, grid2);

        return isSubIsland && up && down && left && right;
    }
}