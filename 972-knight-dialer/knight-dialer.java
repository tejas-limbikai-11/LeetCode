class Solution {
    int mod = 1_000_000_007;

    public int knightDialer(int n) {
        List<List<Integer>> adj = Arrays.asList(
            Arrays.asList(4, 6),  
            Arrays.asList(6, 8),  
            Arrays.asList(7, 9),  
            Arrays.asList(4, 8),  
            Arrays.asList(0, 3, 9),
            Arrays.asList(),      
            Arrays.asList(0, 1, 7),
            Arrays.asList(2, 6),  
            Arrays.asList(1, 3),  
            Arrays.asList(2, 4)   
        );

        int[][] dp = new int[5001][10];
        for(int[] d: dp) Arrays.fill(d, -1);

        int result = 0;

        for(int cell = 0; cell <= 9; cell++) {
            result = (result + solve(n-1, cell, adj, dp)) % mod;
        }
        return result;
    }

    public int solve(int n, int cell, List<List<Integer>> adj, int[][] dp) {
        if(n == 0) return 1;

        if(dp[n][cell] != -1) return dp[n][cell];

        int ans = 0;
        for(int nextCell: adj.get(cell)) {
            ans = (ans + solve(n-1, nextCell, adj, dp)) % mod;
        }
        return dp[n][cell] = ans;
    }
}