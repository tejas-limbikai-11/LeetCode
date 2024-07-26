class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        int[][] shortestPath = new int[n][n];
        
        for(int i=0; i<n; i++) {
            Arrays.fill(shortestPath[i], Integer.MAX_VALUE);
            shortestPath[i][i] = 0;
        }

        for(int[] edge: edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];

            adj.computeIfAbsent(start, k -> new ArrayList<>()).add(new int[] {end, weight});
            adj.computeIfAbsent(end, k -> new ArrayList<>()).add(new int[] {start, weight});
        }

        for(int i=0; i<n; i++) {
            dijkstra(n, adj, shortestPath[i], i);
        }

        return getCity(n, shortestPath, distanceThreshold);
    }

    public int getCity(int n, int[][] shortestPath, int distanceThreshold) {
        int city = -1;
        int fewestCount = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(i != j && shortestPath[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            if(count <= fewestCount) {
                fewestCount = count;
                city = i;
            }
        }

        return city;
    }

    public void dijkstra(int n, Map<Integer, List<int[]>> adj, int[] result, int S) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] {0, S});
        Arrays.fill(result, Integer.MAX_VALUE);
        result[S] = 0;

        while(!pq.isEmpty()) {
            int top[] = pq.poll();
            int d = top[0];
            int node = top[1];

            if(adj.containsKey(node)) {
                for(int[] p : adj.get(node)) {
                    int adjNode = p[0];
                    int dist = p[1];

                    if(d + dist < result[adjNode]) {
                        result[adjNode] = d + dist;
                        pq.add(new int[] {d + dist, adjNode});
                    }
                }
            }
        }
    }    
}