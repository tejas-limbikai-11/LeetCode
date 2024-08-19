class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        return 1 + solve(1, 1, n);
    }

    public int solve(int currA, int clipboard, int n) {
        if(currA == n) return 0;
        if(currA > n) return 1000;

        int copyAllpaste = 1 + 1 + solve(currA * 2, currA, n);
        int paste = 1 + solve(currA + clipboard, clipboard, n);

        return Math.min(copyAllpaste, paste);
    }
}