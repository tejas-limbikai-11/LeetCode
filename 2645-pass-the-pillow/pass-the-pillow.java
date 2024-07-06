class Solution {
    public int passThePillow(int n, int time) {
        boolean reverse = false;
        int i = 1;
        while(time > 0) {
            if(!reverse) {
                i++;
                if(i == n) {
                    reverse = true;
                }
            } 
            else if(reverse) {
                i--;
                if(i == 1) {
                    reverse = false;
                }
            }
            time--;
        } 
       return i;
    }
}