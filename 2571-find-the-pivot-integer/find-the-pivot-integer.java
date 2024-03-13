class Solution {
    public int pivotInteger(int n) {
        int ans = n*(n+1) / 2;
        int sqrt = (int)Math.sqrt(ans);
        if(sqrt*sqrt == ans) return sqrt;
        else return -1;
    }
}