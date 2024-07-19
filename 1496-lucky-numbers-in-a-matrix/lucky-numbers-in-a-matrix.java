class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int num = matrix[i][j];
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int k=0; k<m; k++) {
                    min = Math.min(min, matrix[i][k]);
                }
                for(int l=0; l<n; l++) {
                    max = Math.max(max, matrix[l][j]);
                }
                if(num == min && num == max) {
                    result.add(num);
                }
            }
        }
        return result;
    }
}