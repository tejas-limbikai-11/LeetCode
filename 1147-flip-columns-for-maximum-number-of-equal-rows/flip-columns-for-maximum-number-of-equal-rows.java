class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix[0].length;
        int maxRows = 0;

        for(int[] currRow: matrix) {
            int count = 0;
            int[] invertedRow = new int[n];

            for(int col=0; col<n; col++) {
                invertedRow[col] = currRow[col] == 0 ? 1 : 0;
            }

            for(int[] row: matrix) {
                if(Arrays.equals(row, currRow) || Arrays.equals(row, invertedRow)) {
                    count++;
                }
            }

            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    }
}