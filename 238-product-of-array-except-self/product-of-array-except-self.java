class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int leftProduct[] = new int[nums.length];
        int rightProduct[] = new int[nums.length];
        int ans[] = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            product *= nums[i];
            leftProduct[i] = product;
        }

        product = 1;

        for(int i=nums.length-1; i>=0; i--) {
            product *= nums[i];
            rightProduct[i] = product;
        }

        ans[0] =  rightProduct[1];
        ans[nums.length-1] = leftProduct[nums.length-2];

        for(int i=1; i<nums.length-1; i++) {
            ans[i] = leftProduct[i-1] * rightProduct[i+1];
        }

        return ans;
    }
}