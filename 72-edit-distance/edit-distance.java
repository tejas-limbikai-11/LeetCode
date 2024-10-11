class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        for(int[] d: dp) Arrays.fill(d, -1);
        return editDistance(n, m, word1, word2, dp);
    }

    public int editDistance(int i, int j, String s1, String s2, int[][] dp) {
        if(i == 0) return j;
        if(j == 0) return i;

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s1.charAt(i-1) == s2.charAt(j-1)) {
            return dp[i][j] = editDistance(i-1, j-1, s1, s2, dp);
        }
        else {
            int add = 1 + editDistance(i, j-1, s1, s2, dp);
            int delete = 1 + editDistance(i-1, j, s1, s2, dp);
            int replace = 1 + editDistance(i-1, j-1, s1, s2, dp);

            return dp[i][j] = Math.min(add, Math.min(delete, replace));
        }
    }
}