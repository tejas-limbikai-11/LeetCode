class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                Set<Long> hashSet = new HashSet<>();      

                for(int k=j+1; k<n; k++) {
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long fourth = target - sum;

                    if(hashSet.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int) fourth);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    hashSet.add((long) nums[k]);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }
}