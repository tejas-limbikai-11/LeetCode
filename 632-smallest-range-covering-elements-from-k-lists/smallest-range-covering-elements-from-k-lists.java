class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k  = nums.size();
        int[] arr = new int[k];
        int[] resultRange = {-1000000, 1000000};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int maxEl = Integer.MIN_VALUE;

        for(int i=0; i<k; i++) {
            pq.offer(new int[] {nums.get(i).get(0), i, 0});
            maxEl = Math.max(maxEl, nums.get(i).get(0));
        }

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int minEl = curr[0];
            int listIdx = curr[1];
            int elIdx = curr[2];

            if(maxEl - minEl < resultRange[1] - resultRange[0]) {
                resultRange[0] = minEl;
                resultRange[1] = maxEl;
            }

            if(elIdx + 1 < nums.get(listIdx).size()) {
                int nextElement = nums.get(listIdx).get(elIdx + 1);
                pq.offer(new int[] {nextElement, listIdx, elIdx + 1});
                maxEl = Math.max(maxEl, nextElement);
            }
            else break;
        }
        return resultRange;
    }
}