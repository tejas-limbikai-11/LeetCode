class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> indices = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(nums[i] == key) {
                indices.add(i);
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int idx: indices) {
            for(int x = idx - k; x <= idx + k; x++) {
                if(x >= 0 && x < n) set.add(x);
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int num: set) result.add(num);

        Collections.sort(result);
        return result;
    }
}