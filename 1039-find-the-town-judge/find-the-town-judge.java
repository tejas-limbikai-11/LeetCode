class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 1) return 1;

        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int i=1; i<=n; i++) {
            adj.put(i, new ArrayList<>());
        }

        int[] indegree = new int[n + 1];

        for(int t[]: trust) {
            int u = t[0];
            int v = t[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        for(int key: adj.keySet()) {
            if(adj.get(key).isEmpty() && indegree[key] == n-1) return key;
        }

        return -1;
    }
}