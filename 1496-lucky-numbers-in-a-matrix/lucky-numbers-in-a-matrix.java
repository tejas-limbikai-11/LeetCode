class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int maxFromRowMin = Integer.MIN_VALUE;
        for(int row=0; row<m; row++) {
            int rowMin = Integer.MAX_VALUE;
            for(int col=0; col<n; col++) {
                rowMin = Math.min(rowMin, matrix[row][col]);
            }
            maxFromRowMin = Math.max(maxFromRowMin, rowMin);
        }

        int minFromColMax = Integer.MAX_VALUE;
        for(int col=0; col<n; col++) {
            int colMax = Integer.MIN_VALUE;
            for(int row=0; row<m; row++) {
                colMax = Math.max(colMax, matrix[row][col]);
            }
            minFromColMax = Math.min(minFromColMax, colMax);
        }

        List<Integer> result = new ArrayList<>();
        if(maxFromRowMin == minFromColMax) {
            result.add(maxFromRowMin);
        }

        return result;
    }
}