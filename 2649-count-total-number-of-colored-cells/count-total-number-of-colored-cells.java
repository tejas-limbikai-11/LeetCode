class Solution {
    public long coloredCells(int n) {
        long nSqaure = 1L * n * n;
        long nmin1Sqaure = 1L * (n - 1) * (n - 1);
        return nSqaure + nmin1Sqaure;
    }
}