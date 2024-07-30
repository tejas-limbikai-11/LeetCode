class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int ans[][] = new int[m][n];

        for(int r=0; r<m; r++) {
            for(int c=0; c<n; c++) {
                if(board[r][c] == 0) {
                    if(countNeighbors(board, r, c) == 3) {
                        ans[r][c] = 1;
                    }
                }
                else {
                    if(countNeighbors(board, r, c) < 2) {
                        ans[r][c] = 0;
                    }
                    else if(countNeighbors(board, r, c) == 2 || countNeighbors(board, r, c) == 3) {
                        ans[r][c] = 1;
                    }
                    else {
                        ans[r][c] = 0;
                    }
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = ans[i][j];
            }
        }
    }

    public int countNeighbors(int[][] board, int r, int c) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;

        if(r > 0 && board[r-1][c] == 1) count++;
        if(r < m-1 && board[r+1][c] == 1) count++;
        if(c > 0 && board[r][c-1] == 1) count++;
        if(c < n-1 && board[r][c+1] == 1) count++;
        if(r > 0 && c > 0 && board[r-1][c-1] == 1) count++;
        if(r > 0 && c < n-1 && board[r-1][c+1] == 1) count++;
        if(r < m-1 && c > 0 && board[r+1][c-1] == 1) count++;
        if(r < m-1 && c < n-1 && board[r+1][c+1] == 1) count++;

        return count;
    }
}