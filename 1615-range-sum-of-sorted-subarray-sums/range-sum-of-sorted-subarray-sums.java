class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> subarraySum = new ArrayList<>();
        int mod = 1_000_000_007;

        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=i; j<n; j++) {
                sum += nums[j];
                subarraySum.add(sum);
            }
        }

        Collections.sort(subarraySum);
        int ans = 0;
        for(int i=left-1; i<right; i++) {
            ans = (ans + subarraySum.get(i)) % mod;
        }
        return ans;
    }
}