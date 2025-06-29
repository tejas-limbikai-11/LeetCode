class Solution {
    int MOD = (int) 1e9 + 7;
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int l = 0, r = n-1;
        int result = 0;

        int[] pow = new int[n];
        pow[0] = 1;

        for(int i=1; i<n; i++) {
            pow[i] = (pow[i-1] * 2) % MOD;
        }

        while(l <= r) {
            if(nums[l] + nums[r] <= target) {
                result = (result + pow[r - l]) % MOD;
                l++;
            }
            else r--;
        }
        return result;
    }
}