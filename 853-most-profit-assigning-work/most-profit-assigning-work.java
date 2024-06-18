class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(new int[]{difficulty[i], profit[i]});
        }

        Collections.sort(list, (a,b) -> Integer.compare(a[0], b[0]));

        for(int i=1; i<list.size(); i++) {
            list.get(i)[1] = Math.max(list.get(i)[1], list.get(i-1)[1]);
        }

        int totalProfit = 0;

        for(int i=0; i<m; i++) {
            int l = 0, r = list.size()-1;
            int maxProfit = 0;
            while(l <= r) {
                int mid = l + (r - l) / 2;
                if(list.get(mid)[0] <= worker[i]) {
                    maxProfit = Math.max(maxProfit, list.get(mid)[1]);
                    l = mid + 1;
                } 
                else r = mid - 1;
            }
            totalProfit += maxProfit;
        }
        return totalProfit;
    }
}