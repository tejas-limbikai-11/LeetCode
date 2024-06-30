class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            if(!adj.containsKey(v)) {
                adj.put(v, new ArrayList<>());
            }
            adj.get(v).add(u);
        }

        for (int u = 0; u < n; u++) {
            List<Integer> ancestors = new ArrayList<>();
            boolean[] visited = new boolean[n];
            dfs(u, adj, visited);

            for (int i = 0; i < n; i++) {
                if (i != u && visited[i]) {
                    ancestors.add(i);
                }
            }

            result.add(ancestors);
        }

        return result;
    }

    public void dfs(int u, Map<Integer, List<Integer>> adj,  boolean[] visited) {
        visited[u] = true;

        for(int v: adj.getOrDefault(u, new ArrayList<>())) {
            if(!visited[v]) {
                dfs(v, adj, visited);
            }
        }
    }
}