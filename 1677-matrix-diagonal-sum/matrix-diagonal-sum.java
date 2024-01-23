class Solution {
    public int diagonalSum(int[][] matrix) {
        int n = matrix.length;
        int sum = 0;

        for(int i=0; i<n; i++){
            //primary diagonal  (row = column)
            sum += matrix[i][i];

            //secondary diagonal (row + column = n-1 i.e. i+j = n-1) 
            int j = n-i-1;
            if(i != j){
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}