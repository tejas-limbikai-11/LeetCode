class Solution {
    public int climbStairs(int n) {
        //fibonacci
        int a = 0;
        int b = 1;

        int ways = 0;

        for(int i=0; i<n; i++){
            ways = a + b;
            a = b;
            b = ways;
        }
        return ways;
    }
}