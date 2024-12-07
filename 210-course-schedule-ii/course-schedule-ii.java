class Solution {
    boolean hasCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int i=0; i<numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int[] arr: prerequisites) {
            int u = arr[0];
            int v = arr[1];

            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<numCourses; i++) {
            if(!visited[i]) {
                topoSortDFS(adj, i, visited, inRecursion, stack);
            }
        }

        if(hasCycle) return new int[0];

        int[] result = new int[numCourses];
        int idx = 0;
        while(!stack.isEmpty()) {
            result[idx++] = stack.pop();
        }
        return result;
    }

    public void topoSortDFS(Map<Integer, List<Integer>> adj, int u, boolean[] visited, boolean[] inRecursion, Stack<Integer> stack) {
        visited[u] = true;
        inRecursion[u] = true;

        for(int v: adj.get(u)) {
            if(!visited[v]) {
                topoSortDFS(adj, v, visited, inRecursion, stack);
            }
            else if(inRecursion[v]) {
                hasCycle = true;
                return;
            }
        }
        stack.push(u);
        inRecursion[u] = false;
    }
}