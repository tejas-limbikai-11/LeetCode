class Solution {
    public long countPairs(int n, int[][] edges) {
        long ans = 0;

        int[] rank = new int[n];
        int[] parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        for(int[] edge: edges) {
            int x = edge[0];
            int y = edge[1];
            int xParent = find(x, parent);
            int yParent = find(y, parent);

            if(xParent != yParent) {
                union(x, y, parent, rank);
            }
        }

        long[] componentNodes = new long[n];

        for(int i=0; i<n; i++) {
            int iParent = find(i, parent);
            componentNodes[iParent]++;
        }

        int remainingNodes = n;

        for(int i=0; i<n; i++) {
            long nodes = componentNodes[i];
            ans += (nodes * (remainingNodes - nodes));
            remainingNodes -= nodes;
        }

        return ans;
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