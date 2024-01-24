class Solution {
    public int[] rearrangeArray(int[] nums) {
        int m = nums.length;
        int[] pos = new int[m/2];
        int[] neg = new int[m/2];
        int p = 0;
        int n = 0;

        int i=0;
        while(i<m){
            if(nums[i]<0){
                neg[n] = nums[i];
                n++;
            } 
            else{
                pos[p] = nums[i];
                p++;
            }
            i++;
        }

        p = 0;
        n = 0; 

        for(int j=0; j<m; j++){
            if(j%2 == 0){
                nums[j] = pos[p];
                p++;
            }
            else{
                nums[j] = neg[n];
                n++;
            }
        }
        return nums;
    }
}