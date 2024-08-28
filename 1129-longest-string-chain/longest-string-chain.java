class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int result = 1;

        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
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