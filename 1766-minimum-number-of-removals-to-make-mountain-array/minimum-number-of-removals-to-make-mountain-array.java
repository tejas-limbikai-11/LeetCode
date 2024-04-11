class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        int[] LDS = new int[n];

        //LIS
        for(int i=0; i<n; i++) {
            int ele = nums[i];
            LIS[i] = 1;
            
            for(int j=i-1; j>=0; j--) {
                if(nums[j] < ele) {
                    LIS[i] = Math.max(LIS[i], LIS[j]+1);
                }
            }
        }

        //LDS
        for(int i=n-1; i>=0; i--) {
            int ele = nums[i];
            LDS[i] = 1;
            
            for(int j=i+1; j<n; j++) {
                if(nums[j] < ele) {
                    LDS[i] = Math.max(LDS[i], LDS[j]+1);
                }
            }
        }

        int max = 0;   //max mountain array length

        for(int i=0; i<n; i++) {
            if(LIS[i] == 1 || LDS[i] == 1) continue;
            max = Math.max(max, LIS[i] + LDS[i] - 1);
        }

        return n - max;
    }
}   