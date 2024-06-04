class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean vis[][] = new boolean[n][m];

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    for(int k=0; k<matrix.length; k++) vis[k][j] = true;
                    for(int k=0; k<matrix[0].length; k++) vis[i][k] = true;
                }
            }
       }
       for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(vis[i][j] == true) {
                    matrix[i][j] = 0;
                }
            }
       }
    }
}