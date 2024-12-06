class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int i=0; i<n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int count = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                bfs(adj, i, visited);
                count++;
            }
        }
        return count;
    }

    public void bfs(Map<Integer, List<Integer>> adj, int u, boolean[] visited) {
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