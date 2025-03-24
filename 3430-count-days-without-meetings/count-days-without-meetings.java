class Solution {
    public int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int count = 0;
        int prevEnd = 0;

        for (int[] meet: meetings) {
            int start = meet[0];
            int end = meet[1];

            if(start > prevEnd + 1) {
                count += (start - prevEnd - 1);
            }

            prevEnd = Math.max(prevEnd, end);
        }

        if(prevEnd < days) {
            count += (days - prevEnd);
        }

        return count;
    }
}
