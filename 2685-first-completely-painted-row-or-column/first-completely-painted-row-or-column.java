class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = arr.length;
        int freq[][] = new int[n][2];

        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                int num = mat[i][j];
                freq[num - 1][0] = i;
                freq[num - 1][1] = j;
            }
        }

        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];

        for(int i=0; i<n; i++) {
            int num = arr[i];
            int[] pos = freq[num - 1];
            rows[pos[0]]++;
            cols[pos[1]]++;
            if(rows[pos[0]] == cols.length || cols[pos[1]] == rows.length) {
                return i;
            }
        }
        return -1;
    }
}