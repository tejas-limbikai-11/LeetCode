class Solution {
    static class Job {
        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        Job[] jobs = new Job[n];

        for(int i=0; i<n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a,b) -> a.end - b.end);

        int dp[] = new int[n];
        dp[0] = jobs[0].profit;

        for(int i=1; i<n; i++) {
            int includeProfit = jobs[i].profit;

            int l = binarySearch(jobs, i);
            if(l != -1) includeProfit += dp[l];

            dp[i] = Math.max(includeProfit, dp[i-1]);
        }

        return dp[n-1];
    }

    public int binarySearch(Job jobs[], int idx) {
        int l = 0, r = idx-1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(jobs[mid].end <= jobs[idx].start) {
                if(jobs[mid + 1].end <= jobs[idx].start) {
                    l = mid + 1;
                } 
                else return mid; 
            }
            else r = mid - 1;
        }

        return -1;
    }
}