class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int count = 0;
        int ans = 0;
        int n = arr.length;

        for(int i=0; i<n; i++){
            if(arr[i]==1) count++;
            else{
                ans = Math.max(ans,count);
                count = 0;
            }
        }
        return Math.max(ans,count);
    }
}