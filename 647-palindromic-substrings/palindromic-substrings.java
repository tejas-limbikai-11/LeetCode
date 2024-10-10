class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];
        int count = 0;

        for(int L = 1; L <= n; L++) {
            for(int i = 0; (i+L-1) < n; i++) {
                int j = i + L - 1;
                if(i == j) {    //length = 1
                    dp[i][i] = true;
                }
                else if(i + 1 == j) {   //length = 2
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else {   //length > 2
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
                }

                if(dp[i][j]) count++;
            }
        }
        return count;
    }
}