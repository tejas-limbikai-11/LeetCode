class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = arr.clone();
        int n = temp.length;
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            map.putIfAbsent(temp[i], map.size() + 1);
        }

        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;
    }
}