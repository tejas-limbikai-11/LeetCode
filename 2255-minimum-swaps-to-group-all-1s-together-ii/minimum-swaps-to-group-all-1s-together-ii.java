class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int maxOnes = 0;
        int totalOnes = 0;

        for(int num: nums) {
            if(num == 1) totalOnes++;
        }

        if(totalOnes == 0) return 0;

        int currentOnes = 0;
        for(int i=0; i<totalOnes; i++) {
            if(nums[i] == 1) currentOnes++;
        }

        int l = 0;
        int r = totalOnes - 1;

        while(l < n) {
            if(nums[l] == 1) currentOnes--;
            if(nums[(r + 1) % n] == 1) currentOnes++;
            maxOnes = Math.max(maxOnes, currentOnes);
            l++;
            r = (r + 1) % n;
        }
        return totalOnes - maxOnes;
    }
}