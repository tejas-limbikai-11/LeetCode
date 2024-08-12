class KthLargest {
    int[] nums;
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.nums = nums;
        this.k = k;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int num: nums) {
            add(num);
        }
    }

    public int add(int val) {
        if(pq.size() < k) {
            pq.add(val);
        }
        else if(pq.peek() < val)  {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */