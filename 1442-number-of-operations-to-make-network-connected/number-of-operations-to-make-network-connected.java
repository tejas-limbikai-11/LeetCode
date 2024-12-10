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

        int components = n;
        int[] rank = new int[n];
        int[] parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        for(int[] arr: connections) {
            int x = arr[0];
            int y = arr[1];
            int xParent = find(x, parent);
            int yParent = find(y, parent);

            if(xParent != yParent) {
                union(x, y, parent, rank);
                components--;
            }
        }
        
        return components - 1;
    }
    
    public int find(int i, int[] parent) {
        if(i == parent[i]) return i;

        return parent[i] = find(parent[i], parent);
    }
    
    public void union(int x, int y, int[] parent, int[] rank) {
        int xParent = find(x, parent);
        int yParent = find(y, parent);

        if(xParent == yParent) return;

        if(rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        }
        else if(rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        }
        else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
}