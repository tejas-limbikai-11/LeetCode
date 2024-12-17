
class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()) {
            map.put(ch - 'a', map.getOrDefault(ch - 'a', 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(int key: map.keySet()) {
            pq.offer(new int[] {key, map.get(key)});
        }

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            char ch = (char) (curr[0] + 'a');
            int count = Math.min(curr[1], repeatLimit);
            curr[1] -= count;

            for(int i=0; i<count; i++) {
                sb.append(ch);
            } 

            if(curr[1] > 0) {
                if(pq.isEmpty()) break;

                int[] next = pq.poll();
                char nextCh = (char) (next[0] + 'a');
                sb.append(nextCh);
                next[1]--;

                if(next[1] > 0) pq.offer(next);

                pq.offer(curr);
            } 
        }

        return sb.toString();
    }
}