class Solution {
    static final int MOD = 1_000_000_007;
    
    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long evenPow = findPower(5, evenPositions);
        long oddPow = findPower(4, oddPositions);

        long result = (evenPow * oddPow) % MOD;
        return (int) result;
    }

    public long findPower(long a, long b) {
        if(b == 0) return 1;

        long half = findPower(a, b / 2);
        long result = (half * half) % MOD;

        if(b % 2 != 0) {
            result = (result * a) % MOD;
        }
        return result;
    }
}