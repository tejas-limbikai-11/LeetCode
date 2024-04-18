class Solution {
    int perimeter = 0;

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j);
                    return perimeter;
                }
            }
        }
        return -1;
    }

    public void dfs(int grid[][], int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == 0) {
            perimeter++;
            return;
        }
        if(grid[i][j] == -1) return;

        grid[i][j] = -1;

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}