class Solution {
    public int findChampion(int[][] grid) {
        int maxOnes = 0;
        int idx = 0;

        for(int i=0; i<grid.length; i++) {
            int ones = 0;
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) ones++;
            }
            if(ones > maxOnes) {
                maxOnes = ones;
                idx = i;
            }
        }
        return idx;
    }
}