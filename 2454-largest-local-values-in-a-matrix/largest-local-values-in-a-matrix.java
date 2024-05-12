class Solution {
    public int[][] largestLocal(int[][] grid) {
        int ans[][] = new int[grid.length - 2][grid.length - 2];
        
        for(int i=0; i < ans.length; i++) {
            for(int j=0; j < ans.length; j++) {

                int largest = Integer.MIN_VALUE;
                for(int row = i; row < i+3; row++) {
                    for(int col = j; col < j+3; col++) {
                        largest = Math.max(largest, grid[row][col]);
                    }
                }
                ans[i][j] = largest;
            }
        }
        return ans;
    }
}