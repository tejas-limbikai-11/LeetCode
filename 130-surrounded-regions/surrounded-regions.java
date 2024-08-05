class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                // check for boundary 
                if(i*j == 0 || i == m-1 || j == n-1) {
                    dfs(board, i, j, visited);
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;

        if(i<0 || i>=m || j<0 || j>=n || board[i][j] != 'O' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        dfs(board, i+1, j, visited);
        dfs(board, i-1, j, visited);
        dfs(board, i, j+1, visited);
        dfs(board, i, j-1, visited);
    }
}