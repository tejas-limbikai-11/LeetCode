// @leet start
class Solution {
  public int minOperations(int[] nums, int k) {
    int count = 0;
    PriorityQueue<Long> pq = new PriorityQueue<>();

    for (int num : nums) {
      pq.offer(1L * num);
    }

    while (pq.size() > 1 && pq.peek() < k) {
      long x = pq.poll();
      long y = pq.poll();
      long temp = Math.min(x, y) * 2 + Math.max(x, y);
      pq.offer(temp);
      count++;
    }
    return count;
  }
}
