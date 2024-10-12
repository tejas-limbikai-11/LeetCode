class Solution {
    public int minGroups(int[][] intervals) {
        int count = 0;

        Arrays.sort(intervals, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for(int[] interval: intervals) {
            if(!pq.isEmpty() && pq.peek()[1] < interval[0]) {
                pq.poll();
            }
            pq.offer(interval);
        }

        return pq.size();
    }
}