class Solution {
    public int minDays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int islands = numberOfIslands(grid);

        if(islands == 0 || islands > 1) return 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    islands = numberOfIslands(grid);

                    if(islands > 1 || islands == 0) return 1;

                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    public int numberOfIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islands = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || grid[i][j] != 1) {
            return;
        }

        visited[i][j] = true;

        dfs(grid, i+1, j, visited);
        dfs(grid, i-1, j, visited);
        dfs(grid, i, j+1, visited);
        dfs(grid, i, j-1, visited);
    } 
}