class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for(int i=0; i<n-2; i++) {
            for(int j=0; j<m-2; j++) {
                if(isMagic(grid, i, j)) count++;
            }
        }
        return count;
    }

    public boolean isMagic(int[][] grid, int row, int col) {
        int freq[] = new int[10];
        for(int i = row; i < row + 3; i++) {
            for(int j = col; j < col + 3; j++) {
                if(grid[i][j] < 1 || grid[i][j] > 9 || freq[grid[i][j]] > 0) {
                    return false;
                }
                freq[grid[i][j]] = 1;
            }
        }

        int diag1 = grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2];
        int diag2 = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];
        if(diag1 != diag2) return false;

        for(int i = 0; i < 3; i++) {
            if(grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2] != diag1) return false;
            if(grid[row][col + i] + grid[row + 1][col + i] + grid[row + 2][col + i] != diag1) return false;
        }
        return true;
    }
}