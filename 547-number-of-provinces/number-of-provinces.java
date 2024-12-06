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
                count++;
                dfs(adj, i, visited);
            }
        }
        return count;
    }

    public void dfs(Map<Integer, List<Integer>> adj, int u, boolean[] visited) {
        visited[u] = true;

        for(int v: adj.get(u)) {
            if(!visited[v]) {
                dfs(adj, v, visited);
            }
        }
    }
}