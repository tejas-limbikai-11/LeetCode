class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        int countFresh = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[] {i, j, 0});
                    vis[i][j] = 2;
                }
                else vis[i][j] = 0;

                if(grid[i][j] == 1) countFresh++;
            }
        }

        int time = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        int count = 0;

        while(!queue.isEmpty()) {
            int r = queue.peek()[0];
            int c = queue.peek()[1];
            int t = queue.peek()[2];
            queue.poll();

            time = Math.max(time, t);

            for(int i=0; i<4; i++) {
                int dr = r + drow[i];
                int dc = c + dcol[i];

                if(dr >= 0 && dr < m && dc >= 0 && dc < n && vis[dr][dc] == 0 && grid[dr][dc] == 1) {
                    queue.offer(new int[] {dr, dc, t + 1});
                    vis[dr][dc] = 2;
                    count++;
                }
            }

        }
        if(count != countFresh) return -1;
        return time;
    }
}