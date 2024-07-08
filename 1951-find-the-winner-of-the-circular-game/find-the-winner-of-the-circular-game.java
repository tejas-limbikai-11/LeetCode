class Solution {
    public int findTheWinner(int n, int k) {
        return findWinnerIdx(n, k) + 1;
    }

    public int findWinnerIdx(int n, int k) {
        if(n == 1) return 0;
        int idx = findWinnerIdx(n - 1, k);
        idx = (idx + k) % n;
        return idx;
    }
}