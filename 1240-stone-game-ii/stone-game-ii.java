class Solution {
    public int stoneGameII(int[] piles) {
        int dp[][][] = new int[2][101][101];

        for (int[][] arr2D : dp) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }

        return solveForAlice(1, 0, 1, piles, dp);
    }

    public int solveForAlice(int person, int i, int M, int piles[], int[][][] dp) {
        int n = piles.length;
        if(i >= n) return 0;

        if(dp[person][i][M] != -1) {
            return dp[person][i][M];
        }

        int result = (person == 1) ? -1 : Integer.MAX_VALUE;
        int stones = 0;

        for(int x = 1; x <= Math.min(2 * M, n - i); x++) {
            stones += piles[i + x - 1];

            if(person == 1) { //Alice
                result = Math.max(result, stones + solveForAlice(0, i + x, Math.max(M, x), piles, dp));
            } //Bob
            else result = Math.min(result, solveForAlice(1, i + x, Math.max(M, x), piles, dp));
        }

        return dp[person][i][M] = result;
    }
}