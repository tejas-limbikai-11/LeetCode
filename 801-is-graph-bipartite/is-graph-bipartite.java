class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int i=0; i<V; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int u=0; u<V; u++) {
            for(int v: graph[u]) {
                adj.get(u).add(v);
            }
        }

        int[] color = new int[V];
        Arrays.fill(color, -1);

        for(int i=0; i<V; i++) {
            if(color[i] == -1) {
                if(!checkBipartiteBFS(adj, i, color, 1)) {
                    return false;
                }
            }
        }
        return true; 
    }

    public boolean checkBipartiteBFS(Map<Integer, List<Integer>> adj, int curr, int[] color, int currColor) {
        Queue<Integer> queue = new LinkedList<>();
        color[curr] = currColor;
        queue.offer(curr);
        
        while(!queue.isEmpty()) {
            int u = queue.poll();
            
            for(int v: adj.get(u)) {
                if(color[v] == color[u]) return false;
                else if(color[v] == -1) {
                    color[v] = 1 - color[u];
                    queue.offer(v);
                }
            }
        }
        return true;
    }
}