class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            max = Math.max(max, num);
        }

        int dist[] = new int[max + 1];

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int d = Math.abs(nums[i] - nums[j]);
                dist[d]++;
            }
        }

        for(int i=0; i<max + 1; i++) {
            k -= dist[i];
            if(k <= 0) return i;
        }
        return -1;
    }
}