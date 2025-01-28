class Solution {
    public int findMaxFish(int[][] grid) {
        int maxFishes = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    int count = dfs(i, j, grid);
                    maxFishes = Math.max(maxFishes, count);
                }
            }
        }
        return maxFishes;
    }

    public int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        int currFishes = grid[i][j];
        grid[i][j] = 0;

        int totalFishes = currFishes
                + dfs(i + 1, j, grid)
                + dfs(i - 1, j, grid)
                + dfs(i, j + 1, grid)
                + dfs(i, j - 1, grid);
        return totalFishes;
    }
}
