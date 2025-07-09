class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        List<Integer> list = new ArrayList<>();

        //add all gaps
        list.add(startTime[0]);
        for(int i=0; i<n - 1; i++) {
            int gap = startTime[i + 1] - endTime[i];
            list.add(gap);
        }
        list.add(eventTime - endTime[n-1]);

        int sum = 0, maxGap = 0;
        int i = 0, j = 0;

        while(j < list.size()) {
            sum += list.get(j);

            if(j - i > k) {
                sum -= list.get(i);
                i++;
            }

            maxGap = Math.max(maxGap, sum);
            j++;
        }

        return maxGap;
    }
}