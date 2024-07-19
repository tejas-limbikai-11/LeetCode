class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> rowMin = new ArrayList<>();
        for(int row=0; row<m; row++) {
            int min = Integer.MAX_VALUE;
            for(int col=0; col<n; col++) {
                min = Math.min(min, matrix[row][col]);
            }
            rowMin.add(min);
        }

        List<Integer> colMax = new ArrayList<>();
        for(int col=0; col<n; col++) {
            int max = Integer.MIN_VALUE;
            for(int row=0; row<m; row++) {
                max = Math.max(max, matrix[row][col]);
            }
            colMax.add(max);
        }

        List<Integer> result = new ArrayList<>();
        for(int row=0; row<m; row++) {
            for(int col=0; col<n; col++) {
                if(matrix[row][col] == rowMin.get(row) 
                && matrix[row][col] == colMax.get(col)) {
                    result.add(matrix[row][col]);
                }
            }
        }

        return result;
    }
}