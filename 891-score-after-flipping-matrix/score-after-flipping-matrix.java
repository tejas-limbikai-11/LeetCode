class Solution {
    public int matrixScore(int[][] grid) {
        int result = grid.length * (int) Math.pow(2, grid[0].length - 1);

        for (int[] row : grid) {
            if (row[0] == 0) {
                for (int i = 0; i < row.length; i++) {
                    row[i] = row[i] == 0 ? 1 : 0;
                }
            }
        }

        for (int i = 1; i < grid[0].length; i++) {
            int numZeros = 0, numOnes = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 0) {
                    numZeros++;
                } else {
                    numOnes++;
                }
            }
            result += Math.max(numZeros, numOnes) * Math.pow(2, grid[0].length - i - 1);
        }
        return result;
    }
}