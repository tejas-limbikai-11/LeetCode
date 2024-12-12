class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int gift: gifts) pq.offer(gift);

        while(k-- > 0) {
            int curr = pq.poll();
            pq.offer((int) Math.floor(Math.sqrt(curr)));
        }

        long result = 0;
        while(!pq.isEmpty()) {
            result += pq.poll();
        }
        return result;
    }
}