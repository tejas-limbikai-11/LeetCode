class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String reverseOfS = sb.reverse().toString();

        int LPS = LCS(s, reverseOfS, n, n);
        
        return n - LPS; 
    }

    public int LCS(String s1, String s2, int n, int m) {
        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<n+1; i++) {
            for(int j=0; j<m+1; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(s1.charAt(i-1) ==  s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}