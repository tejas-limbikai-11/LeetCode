class Solution {
    int root_result = 0;
    ArrayList<Integer> count;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        count = new ArrayList<>(n);
        for (int i = 0; i < n; i++) count.add(0);

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (var edge : edges) {
            int u = edge[0];
            int v = edge[1];

            map.computeIfAbsent(u, k -> new ArrayList<Integer>()).add(v);
            map.computeIfAbsent(v, k -> new ArrayList<Integer>()).add(u);
        }
        dfsRoot(map, 0, -1, 0);

        int[] result = new int[n];
        result[0] = root_result;

        dfs(map, 0, -1, result, n);

        return result;
    }

    public void dfs(Map<Integer, List<Integer>> map, int parent, int prev_node, int[] result, int n) {
        if (map.containsKey(parent)) {
            for (var child : map.get(parent)) {
                if (child == prev_node) continue;

                result[child] = result[parent] - count.get(child) + (n - count.get(child));

                dfs(map, child, parent, result, n);
            }
        }
    }

    public int dfsRoot(Map<Integer, List<Integer>> map, int curr_node, int prev_node, int depth) {
        int totalNode = 1;
        root_result += depth;

        if (map.containsKey(curr_node)) {
            for (var child : map.get(curr_node)) {
                if (child == prev_node) continue;
                totalNode += dfsRoot(map, child, curr_node, depth + 1);
            }
        }
        count.set(curr_node, totalNode);
        return totalNode;
    }
}