class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<edges.length; i++) {
            for(int j=0; j<edges[0].length; j++) {
                int edge = edges[i][j];
                map.put(edge, map.getOrDefault(edge, 0) + 1);
            }
        }

        for(Integer key: map.keySet()) {
            if(map.get(key) >= edges.length) return key;
        }
        return -1;
    }
}