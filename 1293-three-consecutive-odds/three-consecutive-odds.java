class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        if(n < 3) return false;

        for(int i=0; i<n-2; i++) {
            // int p = arr[i] * arr[i+1] * arr[i+2];
            int p = arr[i] & arr[i+1] & arr[i+2];
            if(p % 2 == 1) return true;
        }
        return false;
    }
}