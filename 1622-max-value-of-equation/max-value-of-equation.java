class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        //maxHeap to store (yi - xi, xi)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);   
        int result = Integer.MIN_VALUE;

        for(int[] point: points) {
            int xj = point[0];
            int yj = point[1];

            while(!pq.isEmpty() && xj - pq.peek()[1] > k) {
                pq.poll();
            }

            if(!pq.isEmpty()) {                  
                result = Math.max(result, xj + yj + pq.peek()[0]);     //pq.peek()[0] -> (yi - xi)
            }

            pq.offer(new int[] {yj - xj, xj});
        }
        return result;
    }
}