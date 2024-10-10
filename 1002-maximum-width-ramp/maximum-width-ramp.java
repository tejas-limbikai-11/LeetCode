class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        
        int[] rightMax = new int[n];

        int max = nums[n-1];
        rightMax[n-1] = max;

        for(int i=n-2; i>=0; i--) {
            if(nums[i] > max) {
                max = nums[i];
            }
            rightMax[i] = max;
        }

        int i = 0;  //nums 
        int j = 0;  //rightMax
        int result = 0;

        while(j < n) {
            while(nums[i] > rightMax[j]) {
                i++;
            } 
            result = Math.max(result, j - i);
            j++;
        }
        return result;
    }
}