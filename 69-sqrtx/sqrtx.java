class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        long ans = 0;
        for(long i=1; i<=x/2; i++) {
            long sq = i*i;
            if(sq > x) break;
            ans = i;
        }
        return (int) ans;
    }
}