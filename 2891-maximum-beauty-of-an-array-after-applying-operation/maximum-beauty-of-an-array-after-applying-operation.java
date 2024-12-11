class Solution {
    public int maximumBeauty(int[] nums, int k) {
        List<int[]> intervals = new ArrayList<>();
        for(int num: nums) {
            intervals.add(new int[] {num - k, num + k});
        }

        intervals.sort((a, b) -> Integer.compare(a[0], b[0]));

        int maxBeauty = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int[] interval: intervals) {
            while(!queue.isEmpty() && queue.peek()[1] < interval[0]) {
                queue.poll();
            }
            
            queue.offer(interval);
            maxBeauty = Math.max(maxBeauty, queue.size());
        }
        return maxBeauty;
    }
}