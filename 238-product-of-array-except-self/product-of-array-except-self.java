class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int count = 0;
        int arr[] = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                count++;
            }
            else product *= nums[i];
        }

        if(count > 1) {
            arr = new int[nums.length];
            return arr;   
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0 && count == 1) {
                arr = new int[nums.length];
                arr[i] = product;
                return arr;
            }
            else arr[i] = product / nums[i];
        }
        return arr;
    }
}