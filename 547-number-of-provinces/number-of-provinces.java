class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                count++;
                dfs(isConnected, i, visited);
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, int u, boolean[] visited) {
        visited[u] = true;

        for(int v = 0; v < isConnected.length; v++) {
            if(!visited[v] && isConnected[u][v] == 1) {
                dfs(isConnected, v, visited);
            }
        }
    }
}