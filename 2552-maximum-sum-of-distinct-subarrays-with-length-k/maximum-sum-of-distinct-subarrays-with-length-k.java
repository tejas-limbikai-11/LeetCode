class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int j = k;
        long sum = 0;

        for(int x=i; x<j; x++) {
            sum += nums[x];

            map.put(nums[x], map.getOrDefault(nums[x], 0) + 1);
        }
        long maxSum = (map.size() == k) ? sum : 0;

        while(j < n) {
            sum -= nums[i];
            map.put(nums[i], map.get(nums[i]) - 1);
            if(map.get(nums[i]) == 0) map.remove(nums[i]);
            i++;

            sum += nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            j++;

            System.out.println(map.size());
            if(map.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}