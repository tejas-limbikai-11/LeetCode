class Solution {
    public int findMaxK(int[] nums) {
        int arr[] = new int[2001];

        int ans = -1;
        for(int num: nums) {
            if(arr[-num + 1000] == 1) {
                ans = Math.max(ans, Math.abs(num));
            }
            arr[num+1000] = 1;
        }
        return ans;
    }
}