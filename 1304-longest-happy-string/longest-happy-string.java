class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> q[0] - p[0]);
        if(a > 0) pq.offer(new int[] {a, 'a'});
        if(b > 0) pq.offer(new int[] {b, 'b'});
        if(c > 0) pq.offer(new int[] {c, 'c'});
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            int[] arr1 = pq.poll();
            int freq1 = arr1[0];
            char char1 = (char) arr1[1] ;

            if(sb.length() >= 2 && sb.charAt(sb.length() - 1) == char1 && sb.charAt(sb.length() - 2) == char1) {
                if(pq.isEmpty()) break;

                int[] arr2 = pq.poll();
                int freq2 = arr2[0];
                char char2 = (char) arr2[1];

                sb.append(char2);
                if(freq2 > 1) {
                    pq.offer(new int[] {freq2 - 1, char2});
                }

                pq.offer(arr1);
            }
            else {
                sb.append(char1);

                if (freq1 > 1) {
                    pq.offer(new int[] {freq1 - 1, char1});
                }
            }
        }
        return sb.toString();
    }
}