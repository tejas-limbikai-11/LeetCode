class Solution {
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

        return topoSortBFS(adj, numCourses);
    }

    public int[] topoSortBFS(Map<Integer, List<Integer>> adj, int numCourses) {
        int[] result = new int[numCourses];
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

        int idx = 0;
        while(!queue.isEmpty()) {
            int u = queue.poll();
            result[idx++] = u;

            for(int v: adj.get(u)) {
                indegree[v]--;
                if(indegree[v] == 0) {
                    queue.offer(v);
                    count++;
                }
            }
        }

        if(count == numCourses) return result;
        else return new int[0];
    }
}