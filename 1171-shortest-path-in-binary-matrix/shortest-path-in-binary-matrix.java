class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(m == 0 || n == 0 || grid[0][0] != 0) {
            return -1;
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

        int[][] result = new int[n][m];
        for(int[]arr: result) Arrays.fill(arr, Integer.MAX_VALUE);
        Queue<int[][]> pq = new LinkedList<>();

        pq.offer(new int[][] {{0}, {0, 0}});
        result[0][0] = 0;

        while (!pq.isEmpty()) {
            int[][] curr = pq.poll();
            int d = curr[0][0];
            int x = curr[1][0];
            int y = curr[1][1];

            for(int[] dir: directions) {
                int X = x + dir[0];
                int Y = y + dir[1];

                int dist = 1;

                if((X >= 0 && X < m && Y >= 0 && Y < n) && grid[X][Y] == 0 && d + dist < result[X][Y]) {
                    result[X][Y] = d + dist;
                    pq.offer(new int[][] {{d + dist}, {X, Y}});
                }
            }
        }

        if(result[m-1][n-1] == Integer.MAX_VALUE) {
            return -1;
        }

        return result[m-1][n-1] + 1;
    }
}