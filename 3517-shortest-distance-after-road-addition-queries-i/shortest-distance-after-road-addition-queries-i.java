class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++) {
            graph.get(i).add(new int[] {i+1, 1});
        }

        int result[] = new int[queries.length];

        int i = 0;
        for(int[] query: queries) {
            int x = query[0];
            int y = query[1];

            graph.get(x).add(new int[] {y, 1});

            result[i++] = dijkstra(graph, n, 0, n-1);
        }
        return result;
    }

    public int dijkstra(List<List<int[]>> graph, int n, int src, int dest) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new int[] {src, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if(d > dist[u]) continue;

            for(int[] ngbr: graph.get(u)) {
                int v = ngbr[0];
                int weight = ngbr[1];

                if(dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[] {v, dist[v]});
                }
            }
        }

        if(dist[dest] == Integer.MAX_VALUE) return -1;
        return dist[dest];
    }
}