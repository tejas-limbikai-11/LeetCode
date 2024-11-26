class Solution {
    public int findChampion(int n, int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int[] edge: edges) {
            int x = edge[0];
            int y = edge[1];

            map.put(y, map.getOrDefault(y, 0) + 1);
        }

        int count = 0;
        int result = 0;

        for(int i=0; i<n; i++) {
            if(!map.containsKey(i)) {
                result = i;
                count++;
            }
        }

        return (count == 1) ? result : -1;
    }
}