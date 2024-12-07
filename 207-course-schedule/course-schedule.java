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
        
        if(isCycleBFS(numCourses, adj)) return false;  //cycle found
        else return true;
    }

    public boolean isCycleBFS(int numCourses, Map<Integer, List<Integer>> adj) {
        int[] indegree = new int[numCourses];
        int count = 0;

        for(int u=0; u<numCourses; u++) {
            for(int v: adj.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
                count++;
            }
        }
        
        while(!queue.isEmpty()) {
            int u = queue.poll();

            for(int v: adj.get(u)) {
                indegree[v]--;
                if(indegree[v] == 0) {
                    queue.offer(v);
                    count++;
                }
            }
        }

        return count != numCourses;
    }
}