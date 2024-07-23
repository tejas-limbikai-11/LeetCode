class Solution {
    public int minNumberOperations(int[] target) {
        int prev  = 0;
        int curr = 0;
        int ans = 0;

        for(int i=0; i<target.length; i++) {
            curr = target[i];

            if((curr > 0 && prev < 0) || (curr < 0 && prev > 0)) {
                ans += Math.abs(curr);
            }
            else if(Math.abs(curr) > Math.abs(prev)) {
                ans += Math.abs(curr - prev);
            } 
            
            prev = curr;
        }
        return ans;
    }
}