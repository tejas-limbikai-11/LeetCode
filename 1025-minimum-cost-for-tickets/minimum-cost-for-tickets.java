class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int[366];
        Arrays.fill(dp, -1);
        return solve(0, days, costs, dp);
    }

    public int solve(int i, int[] days, int[] costs, int[] dp) {
        if(i >= days.length) return 0;

        if(dp[i] != -1) return dp[i];

        int oneDayPass = costs[0] + solve(i + 1, days, costs, dp);

        int j = i;
        while(j < days.length && days[j] < days[i] + 7) j++;
        int sevenDayPass = costs[1] + solve(j, days, costs, dp);

        j = i;
        while(j < days.length && days[j] < days[i] + 30) j++;
        int thirtyDayPass = costs[2] + solve(j, days, costs, dp);

        return dp[i] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
    }
}