class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if(k > n) return -1;

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0; i<n; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }

        int low = max;
        int high = sum;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int calculatedK = findK(nums, mid);
            if(calculatedK > k) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    public int findK(int[] nums, int k) {
        int count = 1;
        long largestSum = 0;

        for(int i=0; i<nums.length; i++) {
            if(largestSum + nums[i] <= k) {
                largestSum += nums[i];
            }
            else {
                count++;
                largestSum = nums[i];
            }
        }
        return count;
    }
}