class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Collections.singletonList(0);

        List<Integer> result = new ArrayList<>();
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            indegree[u]++;
            indegree[v]++;

            // adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            // adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);     //(Short code for below)

            // Add vertex v to the adjacency list of vertex u
            if (!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(v);
            
            // Add vertex u to the adjacency list of vertex v
            if (!adj.containsKey(v)) {
                adj.put(v, new ArrayList<>());
            }
            adj.get(v).add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(indegree[i] == 1) queue.offer(i);
        }

        while(n > 2) {
            int size = queue.size();
            n -= size;

            while(size-- > 0) {
                int u = queue.poll();
                for(int v: adj.getOrDefault(u, Collections.emptyList())) {
                    indegree[v]--;
                    if(indegree[v] == 1) queue.offer(v);
                }
            }
        }

        while(!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}