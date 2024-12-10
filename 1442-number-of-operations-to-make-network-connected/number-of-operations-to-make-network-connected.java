class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;     //don't have enough edge to connect all

        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int[] arr: connections) {
            int u = arr[0];
            int v = arr[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int count = 0;  //number of connected components
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                DFS(adj, i, visited);
                count++;
            }
        }
        return count - 1;
    }
    
    public void DFS(Map<Integer, List<Integer>> adj, int u, boolean[] visited) {
        if(visited[u]) return;
        visited[u] = true;

        for(int v: adj.get(u)) {
            if(!visited[v]) {
                DFS(adj, v, visited);
            }
        }
    }
}