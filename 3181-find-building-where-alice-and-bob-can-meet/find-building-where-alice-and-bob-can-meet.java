class Solution {
    class Pair {
        int maxHeight;
        int queryIndex;

        Pair(int maxHeight, int queryIndex) {
            this.maxHeight = maxHeight;
            this.queryIndex = queryIndex;
        }
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int totalQueries = queries.length;

        int ans[] = new int[totalQueries];
        Arrays.fill(ans, -1);

        HashMap<Integer, List<Pair>> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return a.maxHeight - b.maxHeight;
        });

        for (int q = 0; q < totalQueries; q++) {
            int i = queries[q][0];
            int j = queries[q][1];

            if (i < j && heights[i] < heights[j]) {
                ans[q] = j;
            } else if (i > j && heights[i] > heights[j]) {
                ans[q] = i;
            } else if (i == j) {
                ans[q] = i;
            } else {
                int maxi = Math.max(i, j);

                if (!map.containsKey(maxi)) {
                    map.put(maxi, new ArrayList<>());
                }
                map.get(maxi).add(new Pair(Math.max(heights[i], heights[j]), q));
            }
        }

        for (int i = 0; i < n; i++) {
            while(pq.size() > 0 && pq.peek().maxHeight < heights[i]){
                Pair pair = pq.remove();
                ans[pair.queryIndex] = i;
            }

            if (map.containsKey(i)) {
                List<Pair> list = map.get(i);
                for (Pair pair : list) {
                    pq.add(pair);
                }
            }
        }
        return ans;
    }
}