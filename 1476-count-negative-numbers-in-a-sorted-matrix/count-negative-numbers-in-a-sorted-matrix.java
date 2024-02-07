class Solution {
    public int countNegatives(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int res = 0;
        int lastNeg  = cols - 1;

        for(int row=0; row < rows; row++) {
            //first element negative => all elements in row are negative
            if(matrix[row][0] < 0) {
                res += cols;
                continue;
            }

            //last element positive => all elements in row are positive
            if(matrix[row][cols-1] > 0) {
                continue;
            }

            int l = 0;
            int r = lastNeg;
            while(l<=r) {
                int m = l + (r-l)/2;
                if(matrix[row][m] < 0) {
                    r = m - 1;
                }
                else{
                    l = m + 1;
                }
            }
            //l points to the first negative element,
            //which means cols - l is a number of such elements
            res += (cols-l);
            lastNeg= l;
        }
        return res;
    }
}