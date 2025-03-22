class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int count = n;

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            union(x, y, parent, size);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int[] edge : edges) {
            int x = edge[0];
            int root = find(x, parent);
            map.put(root, map.getOrDefault(root, 0) + 1);
        }

        int result = 0;
        for(int i=0; i<n; i++) {
            if(i == find(i, parent)) {
                int v = size[i];
                int e = map.getOrDefault(i, 0);
                if((v * (v - 1)) / 2 == e) {
                    result++;
                }
            }
        }

        return result;
    }

    public int find(int i, int[] parent) {
        if (i == parent[i])
            return i;

        return parent[i] = find(parent[i], parent);
    }

    public void union(int x, int y, int[] parent, int[] size) {
        int xParent = find(x, parent);
        int yParent = find(y, parent);

        if (xParent == yParent)
            return;

        if (size[xParent] > size[yParent]) {
            parent[yParent] = xParent;
            size[xParent] += size[yParent];
        } else {
            parent[xParent] = yParent;
            size[yParent] += size[xParent];
        }
    }
}
