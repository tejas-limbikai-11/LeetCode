class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int longestSub = 1;
        int longestSubIdx = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(groups[i] != groups[j] && words[i].length() == words[j].length() && hammingDistanceOne(words[i], words[j])) {
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = 1 + dp[j];
                        parent[i] = j;

                        if(longestSub < dp[i]) {
                            longestSub = dp[i];
                            longestSubIdx = i;
                        }
                    }
                }
            }
        }

        List<String> result = new ArrayList<>();
        while(longestSubIdx != -1) {
            result.add(words[longestSubIdx]);
            longestSubIdx = parent[longestSubIdx];
        }

        Collections.reverse(result);
        return result;
    }

    public boolean hammingDistanceOne(String s1, String s2) {
        int count = 0;

        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                count++;
            }

            if(count > 1) return false;
        }
        return count == 1;
    }
}