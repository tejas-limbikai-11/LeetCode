class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int[] arr: nums1) {
            map.put(arr[0], arr[1]);
        }

        for(int[] arr: nums2) {
            map.put(arr[0], map.getOrDefault(arr[0], 0) + arr[1]);
        }

        int[][] result = new int[map.size()][2];
        int idx = 0;

        for(int key: map.keySet()) {
            result[idx][0] = key;
            result[idx][1] = map.get(key);
            idx++;
        }

        Arrays.sort(result, Comparator.comparingInt(a -> a[0]));
        return result;
    }
}