class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return solve(0, s, wordDict, dp);
    }

    public boolean solve(int idx, String s, List<String> wordDict, Boolean[] dp) {
        int n = s.length();
        if(idx == n) return true;

        if(dp[idx] != null) return dp[idx];

        for(int endIdx = idx + 1; endIdx <= n; endIdx++) {
            String temp = s.substring(idx, endIdx);
            if(wordDict.contains(temp) && solve(endIdx, s, wordDict, dp)) {
                return dp[idx] = true;
            }
        }
        return dp[idx] = false; 
    }
}