class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long score = 0;

        for(int num: nums) pq.offer(num);

        while(k-- > 0) {
            int num = pq.poll();
            score += num;
            int ceil = (num % 3 == 0) ? num/3 : num/3 + 1;
            pq.offer(ceil);
        }

        return score;
    }
}