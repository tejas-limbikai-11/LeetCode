class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++) {
            boolean swapped = false;

            for(int j=0; j<n-i-1; j++) {
                if(nums[j] <= nums[j+1]) continue;
                else {
                    if(Integer.bitCount(nums[j]) == Integer.bitCount(nums[j + 1])) {
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                        swapped = true;
                    }
                    else return false;
                }
            }

            if(!swapped) return true;
        }
        return true;
    }
}