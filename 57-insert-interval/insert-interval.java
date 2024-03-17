class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        for(int[] slot: intervals) {
            // newInterval comes before slot
            if(newInterval[1] < slot[0]) {
                list.add(newInterval);
                newInterval = slot;
            }
            // newInterval comes after slot
            else if(slot[1] < newInterval[0]) {
                list.add(slot);
            }
            // newInterval overlaps with slot
            else {
                newInterval[0] = Math.min(newInterval[0], slot[0]);
                newInterval[1] = Math.max(newInterval[1], slot[1]);
            }
        }

        list.add(newInterval);

        return list.toArray(new int[list.size()] []);
    }
}