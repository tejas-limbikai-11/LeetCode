class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        int result = 0;

        for(int[] arr: grid) {
            for(int num: arr) {
                list.add(num);
            }
        }
        Collections.sort(list);

        int median = list.get(list.size() / 2);

        for(int num: list) {
            int diff = Math.abs(median - num);
            if(diff % x != 0) return -1;

            result += diff / x;
        }
        return result;
    }
}