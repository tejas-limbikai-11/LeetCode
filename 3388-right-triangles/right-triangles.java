class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] rowCounts = new int[rows];
        int[] colCounts = new int[cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1) {
                    rowCounts[i]++;
                    colCounts[j]++;
                }
            }
        }
        long triangles = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1) {
                    triangles += (rowCounts[i] - 1) * (colCounts[j] - 1);
                }
            }
        }
        return triangles;
    }
}