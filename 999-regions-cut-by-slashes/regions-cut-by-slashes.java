class Solution {
    public int regionsBySlashes(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        int regions = 0;

        int[][] result = new int[rows * 3][cols * 3];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i].charAt(j) == '/') {
                    result[i * 3][j * 3 + 2] = 1;
                    result[i * 3 + 1][j * 3 + 1] = 1;
                    result[i * 3 + 2][j * 3] = 1;  
                } 
                else if (grid[i].charAt(j) == '\\') {
                    result[i * 3][j * 3] = 1;
                    result[i * 3 + 1][j * 3 + 1] = 1;
                    result[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (result[i][j] == 0) {
                    dfs(result, i, j);
                    regions++;
                }
            }
        }
        return regions;
    }

    public void dfs(int[][] result, int i, int j) {
        int m = result.length;
        int n = result[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || result[i][j] != 0) {
            return;
        }

        result[i][j] = -1;

        dfs(result, i + 1, j);
        dfs(result, i - 1, j);
        dfs(result, i, j + 1);
        dfs(result, i, j - 1);
    }
}