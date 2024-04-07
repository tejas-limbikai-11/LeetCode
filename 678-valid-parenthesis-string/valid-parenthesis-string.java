class Solution {
    int[][] dp = new int[101][101];

    public boolean solve(int idx, int open, String s, int n) {
        if(idx == n) return open == 0;

        if(dp[idx][open] != -1) return dp[idx][open] == 1;

        boolean isValid = false;

        if(s.charAt(idx) == '*') {
            isValid |= solve(idx+1, open+1, s, n);
            isValid |= solve(idx+1, open, s, n);
            if(open > 0) {
                isValid |= solve(idx+1, open-1, s, n);
            }
        } else if(s.charAt(idx) == '(') {
            isValid |= solve(idx+1, open+1, s, n);
        } else if(open > 0) {
            isValid |= solve(idx+1, open-1, s, n);
        }
        dp[idx][open] = isValid ? 1 : 0;
        return isValid;
    }

    public boolean checkValidString(String s) {
        int n = s.length();
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return solve(0, 0, s, n);
    }
}