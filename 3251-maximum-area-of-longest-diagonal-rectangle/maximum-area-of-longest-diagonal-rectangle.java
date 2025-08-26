class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        double maxDiagonal = 0;

        for(int[] d: dimensions) {
            int l = d[0];
            int b = d[1];
            double diagonalLength = Math.sqrt(l * l + b * b);

            if(diagonalLength > maxDiagonal) {
                maxDiagonal = diagonalLength;
                maxArea = l * b;
            }
            
            if(diagonalLength == maxDiagonal) {
                maxArea = Math.max(maxArea, l * b);
            }
        }

        return maxArea;
    }
}