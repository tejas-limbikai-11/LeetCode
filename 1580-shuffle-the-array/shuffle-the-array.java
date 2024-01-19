class Solution {
    public int[] shuffle(int[] nums, int n) {
        int a = 0;
        int b = n;
        int arr[] = new int[nums.length];
        for(int i=0; i<nums.length; i+=2){
            arr[i] = nums[a];
            arr[i+1] = nums[b];
            a++;
            b++;
        }
        return arr;
    }
}