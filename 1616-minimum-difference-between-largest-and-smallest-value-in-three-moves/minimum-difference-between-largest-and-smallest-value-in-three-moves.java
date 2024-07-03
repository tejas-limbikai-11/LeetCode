class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4) return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());


        for(int num: nums) {
            minHeap.add(num);
            if(minHeap.size() > 4) minHeap.poll();

            maxHeap.add(num);
            if(maxHeap.size() > 4) maxHeap.poll();
        }
        //After this minHeap contains 4 largest numbers
        //And maxHeap contains 4 smallest numbers

        int[] fourLargest = new int[4];
        int[] fourSmallest = new int[4];

        for(int i=0; i<4; i++) {
            fourLargest[i] = minHeap.poll();
            fourSmallest[3 - i] = maxHeap.poll();
        }

        int maxDiff = Integer.MAX_VALUE;
        for(int i=0; i<4; i++) {
            maxDiff = Math.min(maxDiff, fourLargest[i] - fourSmallest[i]);
        }

        return maxDiff;
    }
}