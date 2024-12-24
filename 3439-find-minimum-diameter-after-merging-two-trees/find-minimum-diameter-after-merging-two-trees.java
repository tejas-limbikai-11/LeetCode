class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        Map<Integer, List<Integer>> adj1 = new HashMap<>();
        Map<Integer, List<Integer>> adj2 = new HashMap<>();

        createGraph(edges1, adj1);
        createGraph(edges2, adj2);

        int diameter1 = findDiameter(edges1.length + 1, adj1);
        int diameter2 = findDiameter(edges2.length + 1, adj2);

        int calculatedDiameter = (diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1;

        return Math.max(calculatedDiameter, Math.max(diameter1, diameter2));
    }

    public void createGraph(int[][] edges, Map<Integer, List<Integer>> adj) {
        int n = edges.length + 1;

        for(int i=0; i<n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }

    public int findDiameter(int n, Map<Integer, List<Integer>> adj) {
        int[] farthestNodeResult = farthestNode(n, adj, 0);
        int[] diameterNodeResult = farthestNode(n, adj, farthestNodeResult[0]);

        return diameterNodeResult[1];
    }

    public int[] farthestNode(int n, Map<Integer, List<Integer>> adj, int sourceNode) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(sourceNode);
        visited[sourceNode] = true;

        int maxDist = 0;
        int furthestNode = sourceNode;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size-- > 0) {
                int currNode = queue.poll();
                furthestNode = currNode;

                for(int neighbor: adj.get(currNode)) {
                    if(!visited[neighbor]) {
                        furthestNode = neighbor;
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
            if(!queue.isEmpty()) maxDist++;
        }

        return new int[] {furthestNode, maxDist};
    }
}
