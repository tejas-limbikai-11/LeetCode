class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int result = 0;
        Set<Integer> set = new HashSet<>();

        for(int num: arr1) {
            int val = num;
            while(!set.contains(val) && val > 0) {
                set.add(val);
                val /= 10;
            }
        }

        for(int num: arr2) {
            int val = num;

            while(!set.contains(val) && val > 0) {
                val /= 10;
            }
            result = Math.max(result, (int) Math.log10(val) + 1);
        }
        return result;
    }
}