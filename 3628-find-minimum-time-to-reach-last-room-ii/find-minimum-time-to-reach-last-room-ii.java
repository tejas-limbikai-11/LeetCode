class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int n = moveTime.length;
        int m = moveTime[0].length;
        boolean bool = true;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] {0, 0, 0, 0});

        int[][] minTime = new int[n][m];
        for(int[] min: minTime) {
            Arrays.fill(min, Integer.MAX_VALUE);
        }
        minTime[0][0] = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currTime = curr[0];
            int x = curr[1];
            int y = curr[2];
            int moves = curr[3];

            if(x == n-1 && y == m-1) {
                return currTime;
            }

            for(int[] d: directions) {
                int newX = x + d[0];
                int newY = y + d[1];

                if(newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    int arrivalTime = currTime;
                    if(arrivalTime < moveTime[newX][newY]) {
                        arrivalTime = moveTime[newX][newY];
                    }
                    
                    int moveDuration = (moves % 2 == 0) ? 1 : 2;
                    arrivalTime += moveDuration;

                    if(arrivalTime < minTime[newX][newY]) {
                        minTime[newX][newY] = arrivalTime;
                        pq.offer(new int[] {arrivalTime, newX, newY, moves + 1});
                    }
                }
            }
        }
        return -1;
    }
}