class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] freq = new int[n * n];
        int[] result = new int[2];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int num = grid[i][j];
                freq[num - 1]++;
            }
        }

        for(int i=0; i<n * n; i++) {
           if(freq[i] == 2) result[0] = i+1;
           if(freq[i] == 0) result[1] = i+1;
        }
        return result;
    }
}