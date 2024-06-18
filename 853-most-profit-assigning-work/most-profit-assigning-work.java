class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(new int[]{difficulty[i], profit[i]});
        }

        Collections.sort(list, (a,b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(worker);
    
        int totalProfit = 0;
        int j = 0;
        int maxProfit = 0;

        for(int i=0; i<m; i++) {
            while(j < n && list.get(j)[0] <= worker[i]) {
                maxProfit = Math.max(maxProfit, list.get(j)[1]);
                j++;
            }
            totalProfit += maxProfit;
        }
        return totalProfit;
    }
}