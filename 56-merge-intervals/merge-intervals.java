class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        int[] last = {-1, -1};

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for(int[] interval: intervals) {
            if(last[1] < interval[0]) {
                list.add(interval);
                last = interval;
            }
            else {
                last[0] = Math.min(last[0], interval[0]);
                last[1] = Math.max(last[1], interval[1]);
            }
        }

        return list.toArray(new int[list.size()] []);
    }
}