class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int d1[] = new int[n + 1];
        int d2[] = new int[n + 1];
        Arrays.fill(d1, Integer.MAX_VALUE);
        Arrays.fill(d2, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, 1 });
        d1[1] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int timePassed = curr[0];
            int node = curr[1];

            if (d2[n] != Integer.MAX_VALUE && node == n) {
                return d2[n];
            }

            int div = timePassed / change;
            if (div % 2 == 1) { // Red Light
                timePassed = (div + 1) * change; // Till Green Light
            }

            for (int ngbr : adj.get(node)) {
                if (d1[ngbr] > timePassed + time) {
                    d2[ngbr] = d1[ngbr];
                    d1[ngbr] = timePassed + time;
                    pq.offer(new int[] { timePassed + time, ngbr });
                } 
                else if (d2[ngbr] > timePassed + time && d1[ngbr] != timePassed + time) {
                    d2[ngbr] = timePassed + time;
                    pq.offer(new int[] { timePassed + time, ngbr });
                }
            }
        }
        return -1;
    }
}