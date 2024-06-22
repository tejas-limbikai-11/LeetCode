class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int odds = 0;
        int l = 0;
        int m = 0;
        
        for(int r=0; r<nums.length; r++) {
            if(nums[r] % 2 != 0) odds++;

            while(odds > k) {
                if(nums[l] % 2 != 0) odds--;
                l++;
                m = l;
            }

            if(odds == k) {
                while(nums[m] % 2 == 0) m++;
                count += (m - l) + 1;
            }
        }
        return count;
    }
}