class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int negatives = 0;
        long sum = 0;
        long smallestNum = Long.MAX_VALUE;
        boolean isZero = false;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == 0) isZero = true;
                if(matrix[i][j] < 0) negatives++;
                smallestNum = Math.min(smallestNum, Math.abs(matrix[i][j]));
                sum += Math.abs(matrix[i][j]);
            }
        } 

        if(negatives % 2 == 0 || isZero) return sum;

        return sum - 2 * smallestNum;
    }
}