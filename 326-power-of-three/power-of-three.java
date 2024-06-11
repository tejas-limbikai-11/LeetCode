class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        while(n > 0 && (n % 3 == 0)) {
            n /= 3;
            if(n == 1) return true;
        }
        return false;
    }
}