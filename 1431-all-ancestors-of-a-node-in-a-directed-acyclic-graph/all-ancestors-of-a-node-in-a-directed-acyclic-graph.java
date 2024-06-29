class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<n; i++) {
            result.add(new ArrayList<>());
        }
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            if(!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(v);
        }

        for(int i=0; i<n; i++) {
            int ancestor = i;
            dfs(ancestor, adj, i, result);
        }
        return result;
    }

    public void dfs(int ancestor, Map<Integer, List<Integer>> adj, int currNode, List<List<Integer>> result) {
        if (!adj.containsKey(currNode)) return;
        
        for(int ngbr: adj.get(currNode)) {
            if(result.get(ngbr).isEmpty() || !result.get(ngbr).contains(ancestor)) {
                result.get(ngbr).add(ancestor);
                dfs(ancestor, adj, ngbr, result);
            }
        }
    }
}