class Solution {
  public long continuousSubarrays(int[] nums) {
    int n = nums.length;
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

    int i = 0;
    int j = 0;
    long count = 0;
    
    while(j < n) {
      minHeap.offer(new int[] {nums[j], j});
      maxHeap.offer(new int[] {nums[j], j});

      while(Math.abs(minHeap.peek()[0] - maxHeap.peek()[0]) > 2) {
        i++;

        while(!maxHeap.isEmpty() && maxHeap.peek()[1] < i) maxHeap.poll();
        while(!minHeap.isEmpty() && minHeap.peek()[1] < i) minHeap.poll();
      }
      count += j-i+1;
      j++;
    }
    return count;
  }
}
