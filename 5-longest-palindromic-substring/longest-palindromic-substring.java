class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0;
        Boolean[][] dp = new Boolean[n+1][n+1];

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(isPalindrome(s, i, j, dp)) {
                    if(j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    public boolean isPalindrome(String s, int i, int j, Boolean[][] dp) {
        if(i >= j) return true;

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = isPalindrome(s, i + 1, j - 1, dp);
        }
        else return dp[i][j] = false;
    }
}