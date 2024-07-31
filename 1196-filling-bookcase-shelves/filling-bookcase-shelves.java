class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[][] dp = new int[1001][1001];
        for(int[] d: dp) Arrays.fill(d, -1);

        int remainW = shelfWidth;       //initially whole shelfWidth is remaining width
        return solve(books, shelfWidth, 0, remainW, 0, dp);
    }

    public int solve(int[][] books, int shelfWidth, int i, int remainW, int maxHt, int[][] dp) {
        if(i == books.length) return maxHt;

        if(dp[i][remainW] != -1) {
            return dp[i][remainW];
        }

        int bookW = books[i][0];
        int bookH = books[i][1];
         
        int keep = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;

        //keep
        if(bookW <= remainW) {
            keep = solve(books, shelfWidth, i+1, remainW - bookW, Math.max(maxHt, bookH), dp);
        }

        //skip and put it in next shelf
        skip = maxHt + solve(books, shelfWidth, i+1, shelfWidth - bookW, bookH, dp);

        return dp[i][remainW] = Math.min(keep, skip);
    }
}