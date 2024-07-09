class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for(int i=1; i<arr.length; i++) {
            minDiff = Math.min(minDiff, (arr[i] - arr[i-1]));
        }

        for(int i=1; i<arr.length; i++) {
            if((arr[i] - arr[i-1]) == minDiff) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i-1]);
                list.add(arr[i]);
                result.add(list);
            }
        }
        return result;
    }
}