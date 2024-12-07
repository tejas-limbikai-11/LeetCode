class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int[] pre: prerequisites) {
            int u = pre[0];
            int v = pre[1];

            adj.get(u).add(v);
        }   

        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        
        for(int i=0; i<numCourses; i++) {
            if(!visited[i] && isCycleDFS(i, visited, inRecursion, adj)) {
                return false;  //cycle found
            }
        }
        return true;
    }

    public boolean isCycleDFS(int u, boolean[] visited, boolean[] inRecursion, Map<Integer, List<Integer>> adj) {
        visited[u] = true;
        inRecursion[u] = true;

        for(int v: adj.get(u)) {
            if(!visited[v]) {
                if(isCycleDFS(v, visited, inRecursion, adj)) {
                    return true;
                }
            }
            else if(inRecursion[v]) return true;
        }

        inRecursion[u] = false;
        return false;
    }
}