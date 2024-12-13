class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        long result = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{nums[i], i});
        }
        Collections.sort(list, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
        boolean[] marked = new boolean[n];

        for(int i=0; i<n; i++) {
            int score = list.get(i)[0];
            int idx = list.get(i)[1];

            if (!marked[idx]) {
                result += score;
                marked[idx] = true;
                if (idx > 0 && !marked[idx - 1]) {
                    marked[idx - 1] = true;
                }
                if (idx < n - 1 && !marked[idx + 1]) {
                    marked[idx + 1] = true;
                }
            }
        }
        return result;
    }
}