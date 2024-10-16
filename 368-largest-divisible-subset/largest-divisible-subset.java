class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        int maxLDS = 1;
        int lastIdx = 0;
        
        for(int idx = 0; idx < n; idx++) {
            hash[idx] = idx;

            for(int prevIdx = 0; prevIdx < idx; prevIdx++) {
                if(nums[idx] % nums[prevIdx] == 0 && 1 + dp[prevIdx] > dp[idx]) {
                    dp[idx] = 1 + dp[prevIdx];
                    hash[idx] = prevIdx;
                }
            }

            if(dp[idx] > maxLDS) {
                maxLDS = dp[idx];
                lastIdx = idx;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(nums[lastIdx]);

        while(hash[lastIdx] != lastIdx) {
            lastIdx = hash[lastIdx];
            list.add(nums[lastIdx]);
        }

        Collections.reverse(list);
        return list;
    }
}