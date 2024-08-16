class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int m = arrays.get(0).size();
        int max = arrays.get(0).get(m-1);
        int diff = 0;

        for(int i=1; i<arrays.size(); i++) {
            int n = arrays.get(i).size();
            diff = Math.max(diff, Math.max(max - arrays.get(i).get(0), arrays.get(i).get(n-1) - min));

            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(n-1));
        }
        return diff;
    }
}