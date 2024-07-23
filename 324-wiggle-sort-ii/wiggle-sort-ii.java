class Solution {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int n: nums) maxHeap.offer(n);

        for(int i=1; i<nums.length; i+=2) {
            nums[i] = maxHeap.poll();
        }

        for(int i=0; i<nums.length; i+=2) {
            nums[i] = maxHeap.poll();
        }
    }
}