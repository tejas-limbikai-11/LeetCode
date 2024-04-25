class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int dp[] = new int[26];
        int ans = 0;

        for(int i=0; i<n; i++) {
            int curr = s.charAt(i) - 'a';
            int left = Math.max(0, curr - k);
            int right = Math.min(25, curr + k);
            int longest = 0;

            for(int j=left; j<=right; j++) {
                longest = Math.max(longest, dp[j]);
            }
            dp[curr] = Math.max(dp[curr], longest+1);
            ans = Math.max(ans, dp[curr]);
        }
        return ans;
    }
}