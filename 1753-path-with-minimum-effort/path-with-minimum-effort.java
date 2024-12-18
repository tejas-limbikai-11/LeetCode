class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] result = new int[m][n];
        for(int[] arr: result) Arrays.fill(arr, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        result[0][0] = 0;
        pq.offer(new int[] {0, 0, 0});   //diff, i, j

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int diff = curr[0];
            int x = curr[1];
            int y = curr[2];

            for(int[] dir: directions) {
                int X = x + dir[0];
                int Y = y + dir[1];

                if(X >= 0 && X < m && Y >= 0 && Y < n) {
                    int absDiff = Math.abs(heights[x][y] - heights[X][Y]);
                    int maxDiff = Math.max(diff, absDiff);

                    if(maxDiff < result[X][Y]) {
                        result[X][Y] = maxDiff;
                        pq.offer(new int[] {maxDiff, X, Y});
                    }
                }
            }
        }
        return result[m-1][n-1];
    }
}