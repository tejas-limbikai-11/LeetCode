class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;

        char[][] rotatedBox = new char[m][n];

        for(int i=0; i<n; i++) {
            int end = m - 1;
            for(int j=m-1; j>=0; j--) {
                if(box[i][j] == '*') {
                    end = j - 1;
                }
                else if(box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][end] = '#';
                    end--;
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                rotatedBox[j][n - i - 1] = box[i][j];
            }
        }
        return rotatedBox;
    }
}