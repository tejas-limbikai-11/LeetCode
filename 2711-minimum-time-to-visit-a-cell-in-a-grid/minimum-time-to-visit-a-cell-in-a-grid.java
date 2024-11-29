class Solution {
    public int minimumTime(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[n][m];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0, 0});   //time, i, j

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int i = curr[1];
            int j = curr[2];

            if(i == n - 1 && j == m - 1) return time;

            if(visited[i][j]) continue;
            visited[i][j] = true;

            for(int[] dir: directions) {
                int r = i + dir[0];
                int c = j + dir[1];

                if(r >= 0 && r < n && c >= 0 && c < m) {
                    if(grid[r][c] <= time + 1) {
                        pq.offer(new int[]{time + 1, r, c});
                    }
                    else if((grid[r][c] - time) % 2 == 0) {
                        pq.offer(new int[]{grid[r][c] + 1, r, c});
                    }
                    else if((grid[r][c] - time) % 2 != 0) {
                        pq.offer(new int[]{grid[r][c], r, c});
                    }
                }
            }
        }
        return -1;
    }
}