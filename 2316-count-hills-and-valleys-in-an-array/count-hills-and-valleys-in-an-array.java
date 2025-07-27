class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int result = 0;
        List<Integer> list = new ArrayList<>();

        list.add(nums[0]);
        for(int i=1; i<n; i++) {
            if(nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
        }

        for(int i=1; i<list.size()-1; i++) {
            int curr = list.get(i);
            int prev = list.get(i-1);
            int next = list.get(i+1);

            if((prev < curr && next < curr) || (prev > curr && next > curr)) {
                result++;
            } 
        }
        return result;
    }
}