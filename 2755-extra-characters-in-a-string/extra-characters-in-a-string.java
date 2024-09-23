class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> set = new HashSet<>();

        for(String str: dictionary) {
            set.add(str);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(0, s, n, set, dp);
    }

    public int solve(int idx, String s, int n, Set<String> set, int[] dp) {
        if(idx >= n) return 0;

        if(dp[idx] != -1) return dp[idx];

        int notTake = 1 + solve(idx + 1, s, n, set, dp);

        int take = Integer.MAX_VALUE;
        for(int j = idx; j < n; j++) {
            String curr = s.substring(idx, j + 1);
            if(set.contains(curr)) {
                take = Math.min(take, solve(j + 1, s, n, set, dp));
            }
        }

        return dp[idx] = Math.min(notTake, take);
    }
}