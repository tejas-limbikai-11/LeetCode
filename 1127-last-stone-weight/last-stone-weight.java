class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int stone: stones) pq.add(stone);
        while(pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if(x < y) {
                int z = y - x;
                pq.add(z);
            }
        }
        if(!pq.isEmpty()) return pq.peek();
        else return 0;
    }
}