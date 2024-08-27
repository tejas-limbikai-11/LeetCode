class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double pathProb = succProb[i];

            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, pathProb));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, pathProb));
        }

        double[] maxProb = new double[n];
        maxProb[start] = 1d;

        //max-heap
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getKey(), a.getKey()));
        pq.add(new Pair<>(1.0, start));

        while(!pq.isEmpty()) {
            Pair<Double, Integer> currPair = pq.poll();
            double currProb = currPair.getKey();
            int currNode = currPair.getValue();

            if(currNode == end) return currProb;

            for(Pair<Integer, Double> next: graph.getOrDefault(currNode, new ArrayList<>())) {
                int nextNode = next.getKey();
                double pathProb = next.getValue();

                if(currProb * pathProb > maxProb[nextNode]) {
                    maxProb[nextNode] = currProb * pathProb;
                    pq.add(new Pair<>(maxProb[nextNode], nextNode));
                }
            }
        }
        return 0d;
    }
}