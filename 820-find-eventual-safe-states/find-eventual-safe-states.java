class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];
        for(int i=0; i<V; i++) {
            for(int v: graph[i]) {
                adj.get(v).add(i);
                indegree[i]++;
            }
        }
         
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<V; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        while(!queue.isEmpty()) {
            int u = queue.poll();
            safeNodes.add(u);

            for(int v: adj.get(u)) {
                indegree[v]--;

                if(indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}
