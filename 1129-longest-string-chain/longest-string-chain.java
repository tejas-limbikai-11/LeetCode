class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] d: dp) Arrays.fill(d, -1);

        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        return solve(words, 0, -1, dp);
    }

    public int solve(String[] words, int idx, int prevIdx, int[][] dp) {
        if(idx >= words.length) return 0;

        if(dp[idx][prevIdx + 1] != -1) {
            return dp[idx][prevIdx + 1];
        }

        int take = 0;
        if(prevIdx == -1 || isPredecessor(words[prevIdx], words[idx])) {
            take = 1 + solve(words, idx + 1, idx, dp);
        }

        int skip = solve(words, idx + 1, prevIdx, dp);

        return dp[idx][prevIdx + 1] = Math.max(take, skip);
    }

    public boolean isPredecessor(String prev, String curr) {
        int m = prev.length();
        int n = curr.length();

        if(m >= n || n - m != 1) return false;

        int i = 0, j = 0;

        while(i < m && j < n) {
            if(prev.charAt(i) == curr.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }
}