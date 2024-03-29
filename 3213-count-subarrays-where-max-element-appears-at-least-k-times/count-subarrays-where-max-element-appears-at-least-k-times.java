class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long result = 0;

        int maxElement = 0;
        for(int i: nums) maxElement = Math.max(maxElement, i);

        ArrayList<Integer> maxIndices = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == maxElement) maxIndices.add(i);

            int size = maxIndices.size();

            if(size >= k) {
                int lastIndex = maxIndices.get(size - k);  //last index at which max element was found which makes subarray valid 
                result += (lastIndex + 1);
            }
        }
        return result;
    }
}