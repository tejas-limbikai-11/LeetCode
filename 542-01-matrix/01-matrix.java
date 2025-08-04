class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] result = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat[i][j] == 0) {
                    result[i][j] = 0;
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});

                }
                else result[i][j] = Integer.MAX_VALUE;
            }
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while(!queue.isEmpty()) {
            int curr[] = queue.poll();
            int i = curr[0], j = curr[1];

            for(int[] dir: directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];

                if(ni >= 0 && ni < n && nj >= 0 && nj < m && !visited[ni][nj]) {
                    result[ni][nj] = result[i][j] + 1;
                    visited[ni][nj] = true;
                    queue.offer(new int[] {ni, nj});
                }
            }
        }

        return result;
    }
}