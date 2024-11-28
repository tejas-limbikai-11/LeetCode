class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Map<String, Integer> map = new HashMap<>();

        for(int[] row: matrix) {
            StringBuilder rowPattern = new StringBuilder();
            int firstVal = row[0];

            for(int col = 0; col < n; col++) {
                rowPattern.append(row[col] == firstVal ? "S" : "B");
            }

            map.put(rowPattern.toString(), map.getOrDefault(rowPattern.toString(), 0) + 1);
        }

        int maxRows = 0;
        for(int count: map.values()) {
            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    }
}