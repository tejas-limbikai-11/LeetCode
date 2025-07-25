class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        int negatives = 0;
        int maxNum = Integer.MIN_VALUE;

        for(int num: nums) {
            if(num > 0) {
                if(!set.contains(num)) {
                    sum += num;
                    set.add(num);
                }
            }
            else negatives++;

            maxNum = Math.max(maxNum, num);
        }

        if(negatives == nums.length) return maxNum;

        return sum;
    }
}