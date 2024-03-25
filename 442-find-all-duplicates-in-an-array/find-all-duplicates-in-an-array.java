class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i: nums) {
            i = Math.abs(i);
            if(nums[i-1] < 0) list.add(i);
            nums[i-1] = nums[i-1] * -1;
        }
        return list;
    }
}