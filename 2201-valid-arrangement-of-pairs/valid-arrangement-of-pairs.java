class Solution {
    Map<Integer, Queue<Integer>> graph;
    LinkedList<Integer> queue = new LinkedList();
    Map<Integer, Integer> outDegree;
    Map<Integer, Integer> inDegree;
    int start, end;

    public int[][] validArrangement(int[][] pairs) {
        int n = pairs.length;
        inDegree = new HashMap();
        outDegree = new HashMap();
        graph = new HashMap();

        for(int[] pair : pairs) {
            int a = pair[0];
            int b = pair[1];
            inDegree.putIfAbsent(b, 0);
            outDegree.putIfAbsent(a, 0);

            outDegree.put(a, outDegree.get(a) + 1);
            inDegree.put(b, inDegree.get(b) + 1);

            graph.putIfAbsent(a, new LinkedList());
            graph.get(a).add(b);
        }

        start = -1;
        end = -1;

        for(Integer node : outDegree.keySet()) {
            Integer in = inDegree.get(node);
            Integer out = outDegree.get(node);

            if((in == null && out != null) || out > in) {
                start = node;
            }
        }
        for(Integer node : inDegree.keySet()) {
            Integer in = inDegree.get(node);
            Integer out = outDegree.get(node);

            if((out == null && in != null) || in > out) {
                end = node;
            }
        }

        if(start == -1)
            start = pairs[0][0];

        Dfs(start);

        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            ans[i][0] = queue.removeLast();
            ans[i][1] = queue.removeLast();
        }
        return ans;
    }

    public void Dfs(int node) {
        Queue<Integer> children = graph.get(node);
        while(children != null && !children.isEmpty()) {
            int nei = children.poll();
            if(nei == end && children.size() > 1) {
                children.add(nei);
                continue;
            }
            Dfs(nei);
            queue.add(nei);
        }
        queue.add(node);
    }
}