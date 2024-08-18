class Solution {
    public int nthUglyNumber(int n) {
       PriorityQueue<Long> pq = new PriorityQueue<>();
       Set<Long> set = new HashSet<>();
       pq.offer(1L);
       long result = 0;

        for(int i=0; i<n; i++) {
            result = pq.poll();
            long mul2 = result * 2;
            long mul3 = result * 3;
            long mul5 = result * 5;

            if(!set.contains(mul2)) {
                pq.offer(mul2);
                set.add(mul2);
            }
            if(!set.contains(mul3)) {
                pq.offer(mul3);
                set.add(mul3);
            }
            if(!set.contains(mul5)) {
                pq.offer(mul5);
                set.add(mul5);
            }
       } 
       return (int) result;
    }
}