class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        List<Integer> smallerNums = new ArrayList<>();
        List<Integer> greaterNums = new ArrayList<>();
        int pivotFreq = 0;

        for(int num: nums) {
            if(num < pivot) smallerNums.add(num);
            else if(num > pivot) greaterNums.add(num);
            else pivotFreq++;
        }

        int[] result = new int[n];
        int idx = 0;
        for(int num: smallerNums) {
            result[idx++] = num;
        }
        while(pivotFreq > 0) {
            result[idx++] = pivot;
            pivotFreq--;
        }
        for(int num: greaterNums) {
            result[idx++] = num;
        }
        return result;
    }
}