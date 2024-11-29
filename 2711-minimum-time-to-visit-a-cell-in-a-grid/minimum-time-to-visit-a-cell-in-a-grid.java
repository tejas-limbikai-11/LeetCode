class Solution {
    public int minimumTime(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;
        
        int[][] result = new int[n][m];
        for(int[] arr: result) Arrays.fill(arr, Integer.MAX_VALUE);
        result[0][0] = 0;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[n][m];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});   //time, i, j

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int i = curr[1];
            int j = curr[2];

            if(visited[i][j]) continue;
            visited[i][j] = true;

            for(int[] dir: directions) {
                int r = i + dir[0];
                int c = j + dir[1];

                if(r >= 0 && r < n && c >= 0 && c < m) {
                    int nextTime = 0;

                    if(grid[r][c] <= time + 1) {
                        nextTime = time + 1;
                    }
                    else if((grid[r][c] - time) % 2 == 0) {
                        nextTime = grid[r][c] + 1;
                    }
                    else if((grid[r][c] - time) % 2 != 0) {
                        nextTime = grid[r][c];
                    }

                    if(nextTime < result[r][c]) {
                        result[r][c] = nextTime;
                        pq.offer(new int[]{nextTime, r, c});
                    }
                }
            }
        }
        return result[n-1][m-1];
    }
}