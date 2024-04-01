class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge> graph[] = new ArrayList[n];

        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u));
        }

        boolean visited[] = new boolean[n];
        return hasPath(graph, source, destination, visited);
    }

    public boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean visited[]) {
        if(src == dest) return true;
        visited[src] = true;
        for(Edge e: graph[src]) {
            if(!visited[e.dest] && hasPath(graph, e.dest, dest, visited)) {
                return true;
            }
        }
        return false;
    }

    class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
}