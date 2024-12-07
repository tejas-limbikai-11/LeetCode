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
                if(!checkBipartiteDFS(adj, i, color, 1)) {
                    return false;
                }
            }
        }
        return true; 
    }

    public boolean checkBipartiteDFS(Map<Integer, List<Integer>> adj, int curr, int[] color, int currColor) {
        color[curr] = currColor;
        
        for(int v: adj.get(curr)) {
            if(color[v] == color[curr]) return false;
            
            if(color[v] == -1) {
                int colorOfV = 1 - currColor;
                if(!checkBipartiteDFS(adj, v, color, colorOfV)) {
                    return false;
                }
            }
        }
        return true;
    }
}