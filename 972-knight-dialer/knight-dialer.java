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

        int result = 0;

        for(int cell = 0; cell <= 9; cell++) {
            dp[0][cell] = 1;
        }

        for(int i=1; i<n; i++) {
            for(int cell = 0; cell <= 9; cell++) {
                int ans = 0;
                for(int nextCell: adj.get(cell)) {
                    ans = (ans + dp[i-1][nextCell]) % mod;
                }
                dp[i][cell] = ans;
            }
        }

        for(int cell = 0; cell <= 9; cell++) {
            result = (result + dp[n-1][cell]) % mod;
        }
        return result;
    }
}