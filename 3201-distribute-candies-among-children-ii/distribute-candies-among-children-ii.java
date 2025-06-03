class Solution {
    public long distributeCandies(int n, int limit) {
        long count = 0;

        //child 1
        int minCh1 = Math.max(0, n - 2 * limit);
        int maxCh1 = Math.min(n, limit);

        for(int i=minCh1; i<=maxCh1; i++) {
            int N = n - i;  //for child 2 and child 2
            int minCh2 = Math.max(0, N - limit);
            int maxCh2 = Math.min(N, limit);

            count += (maxCh2 - minCh2 + 1);
        }
        return count;
    }
}