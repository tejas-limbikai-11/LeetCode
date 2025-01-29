class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] rank = new int[n + 1];
        int[] parent = new int[n + 1];
        
        for(int i=1; i<=n; i++) {
            parent[i] = i;
        }

        for(int[] edge: edges) {
            int x = edge[0];
            int y = edge[1];
            if(find(x, parent) == find(y, parent)) {
                return edge;
            }
            union(x, y, parent, rank);
        }
        return new int[0];
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
