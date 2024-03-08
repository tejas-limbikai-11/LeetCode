class Solution {
    public int maxFrequencyElements(int[] nums) {
        if(nums.length == 1) return 1;
        int max = 0;
        int total = 0;

        int freq[] = new int[100];

        for(int i=0; i<nums.length; i++) { 
            freq[nums[i]-1]++;
        }
        for(int i=0; i<freq.length; i++) {
            max = Math.max(max, freq[i]);
        } 

        for(int i=0; i<freq.length; i++) {
            if(freq[i] == max) {
                total += max;
            }
        }

        return total;
    }
}