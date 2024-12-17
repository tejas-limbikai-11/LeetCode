class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int i=1; i<=n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int[] time: times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adj.get(u).add(new int[] {v, w});
        }

        int[] result = new int[n+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        result[k] = 0;
        pq.offer(new int[] {0, k});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];

            for(int[] arr: adj.get(node)) {
                int adjNode = arr[0];
                int dist = arr[1];

                if(d + dist < result[adjNode]) {
                    result[adjNode] = d + dist;
                    pq.offer(new int[] {d + dist, adjNode});
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for(int i=1; i<=n; i++) {
            if(result[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, result[i]);
        }

        return ans;
    }
}