class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
		ans.add(new ArrayList<>());

        HashSet<Integer> set1 = new HashSet<>();
        for(int num: nums1) set1.add(num);
        HashSet<Integer> set2 = new HashSet<>();
        for(int num: nums2) set2.add(num);

        for(int num: set1) {
            if(!set2.contains(num)) {
                ans.get(0).add(num);
            }
        }
        for(int num: set2) {
            if(!set1.contains(num)) {
                ans.get(1).add(num);
            }
        }
        return ans;
    }
}