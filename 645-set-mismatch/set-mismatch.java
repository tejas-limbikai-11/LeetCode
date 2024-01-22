class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans[] = new int[2];
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                ans[0] = nums[i];
                break;
            }
        }

        int actualSum = 0;
        for(int i=0; i<nums.length; i++){
            actualSum += nums[i];
        }

        int expSum = n*(n+1)/2;
        ans[1] = (expSum - actualSum) + ans[0];
        return ans;
    }
}