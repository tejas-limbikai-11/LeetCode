class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp , 1);
        int[] prevIdx = new int[n];
        Arrays.fill(prevIdx , -1);
        int maxLDS = 1;
        int lastIdx = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] % nums[j] == 0) {
                    if(dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        prevIdx[i] = j;
                    }

                    if(dp[i] > maxLDS) {
                        maxLDS = dp[i];
                        lastIdx = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while(lastIdx != -1) {
            result.add(nums[lastIdx]);
            lastIdx = prevIdx[lastIdx];
        }
        return result;
    }
}