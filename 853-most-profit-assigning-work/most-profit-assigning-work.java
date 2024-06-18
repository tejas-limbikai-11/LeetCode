class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(int i=0; i<n; i++) {
            int prof = profit[i];
            int diff = difficulty[i];
            pq.offer(new int[]{prof, diff});
        }

        //sort worker array in descending order
        Arrays.sort(worker);
        for(int i=0; i<m/2; i++) {
            int temp = worker[i];
            worker[i] = worker[m-1-i];
            worker[m-1-i] = temp;
        }

        int i = 0;
        int maxProfit = 0;
        while(i < m && !pq.isEmpty()) {
            if(pq.peek()[1] > worker[i]) {
                pq.poll();
            } else {
                maxProfit += pq.peek()[0];
                i++;
            }
        }
        return maxProfit;
    }
}