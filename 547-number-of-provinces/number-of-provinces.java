class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                count++;
                bfs(isConnected, i, visited);
            }
        }
        return count;
    }

    public void bfs(int[][] isConnected, int u, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);
        visited[u] = true;

        while(!queue.isEmpty()) {
            u = queue.poll();

            for(int v = 0; v < isConnected.length; v++) {
                if(!visited[v] && isConnected[u][v] == 1) {
                    bfs(isConnected, v, visited);
                }
            }
        }
    }
}