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
                BFS(adj, i, visited);
                count++;
            }
        }
        return count - 1;
    }
    
    public void BFS(Map<Integer, List<Integer>> adj, int u, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(u);
        visited[u] = true;
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            
            for(int v: adj.get(curr)) {
                if(!visited[v]) {
                    queue.offer(v);
                    visited[v] = true;
                }
            }
        }
    }   
}