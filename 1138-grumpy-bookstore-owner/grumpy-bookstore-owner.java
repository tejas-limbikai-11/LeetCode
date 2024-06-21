class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0;
        int window = 0;
        int maxWindow = 0;
        int l = 0;

        for(int r=0; r<customers.length; r++) {
            if(grumpy[r] == 0) {
                satisfied += customers[r];
            } 
            else window += customers[r];

            if(r-l+1 > minutes) {
                if(grumpy[l] == 1) {
                    window -= customers[l];
                }
                l++;
            }
            maxWindow = Math.max(maxWindow, window);
        }
        return satisfied + maxWindow;
    }
}