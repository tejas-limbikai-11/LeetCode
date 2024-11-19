class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        int i = 0;
        int j = 0;
        long sum = 0;
        long maxSum = 0;

        while(j < n) {
            while(set.contains(nums[j])) {
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            sum += nums[j];
            set.add(nums[j]);

            if(j-i+1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            j++;
        }
        return maxSum;
    }
}