class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] result = new int[n][m];
        for(int[] arr: result) Arrays.fill(arr, Integer.MAX_VALUE);
        result[0][0] = 0;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});   //d, i, j

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int i = curr[1];
            int j = curr[2];

            for(int[] dir: directions) {
                int newI = i + dir[0];
                int newJ = j + dir[1];

                if(newI >= 0 && newI < n && newJ >= 0 && newJ < m) {
                    int wt = (grid[newI][newJ] == 1) ? 1 : 0;

                    if(d + wt < result[newI][newJ]) {
                        result[newI][newJ] = d + wt;
                        pq.offer(new int[] {d + wt, newI, newJ});
                    }
                }
            }
        }
        return result[n-1][m-1];
    }
}