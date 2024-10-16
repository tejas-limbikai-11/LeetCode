class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int result = 1;

        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        for(int idx = 0; idx < n; idx++) {
            for(int prevIdx = 0; prevIdx < idx; prevIdx++) {
                if(isPredecessor(words[prevIdx], words[idx])) {
                    dp[idx] = Math.max(dp[idx], 1 + dp[prevIdx]);
                }
            }
            result = Math.max(result, dp[idx]);
        }
        return result;
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