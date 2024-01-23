class Solution {
    public int diagonalSum(int[][] matrix) {
        int n = matrix.length;
        int sum = 0;

        for(int i=0; i<n; i++){
            //primary diagonal
            sum += matrix[i][i];

            //secondary diagonal
            int j = n-i-1;
            if(i != j){
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}