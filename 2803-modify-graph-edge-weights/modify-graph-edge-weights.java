class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int src, int dest, int target) {
        long currShortestDist = dijkstra(edges, n, src, dest);
        if(currShortestDist < target) return new int[0][];

        boolean matchedTarget = (currShortestDist == target);

        for(int[] edge: edges) {
            if(edge[2] == -1) {
                edge[2] = matchedTarget ? (int) 2e9 : 1;

                if(!matchedTarget) {
                    long newShortestDist = dijkstra(edges, n, src, dest);

                    if(newShortestDist <= target) {
                        matchedTarget = true;
                        edge[2] += (target - newShortestDist);
                    }
                }
            }
        }
        if(!matchedTarget) return new int[0][];
        return edges;
    }

    public long dijkstra(int[][] edges, int n, int src, int dest) {
        Map<Long, List<long[]>> adj = new HashMap<>();

        for(int[] edge: edges) {
            if(edge[2] != -1) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                adj.computeIfAbsent((long) u, k -> new ArrayList<>()).add(new long[] {v, wt});
                adj.computeIfAbsent((long) v, k -> new ArrayList<>()).add(new long[] {u, wt});
            }
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        long[] result = new long[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(result, Long.MAX_VALUE);

        result[src] = 0;
        pq.offer(new long[] {0, src}); // (distance, node)

        while(!pq.isEmpty()) {
            long[] curr = pq.poll();
            long currDist = curr[0];
            int currNode = (int) curr[1];

            if(visited[currNode]) continue;
            visited[currNode] = true;

            if(!adj.containsKey((long) currNode)) continue;

            for(long[] neighbor : adj.get((long) currNode)) {
                int ngbr = (int) neighbor[0];
                long weight = neighbor[1];

                if(result[ngbr] > currDist + weight) {
                    result[ngbr] = currDist + weight;
                    pq.offer(new long[] {result[ngbr], ngbr});
                }
            }
        }
        return result[dest];
    }
}