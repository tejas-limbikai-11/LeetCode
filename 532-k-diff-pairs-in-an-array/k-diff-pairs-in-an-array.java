class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> uniqueNumbers = new HashSet<>();
        Set<Integer> seenPairs = new HashSet<>();

        int count = 0;

        for(int num: nums) {
            if(uniqueNumbers.contains(num - k)) {
                if(!seenPairs.contains(num - k)) {
                    count++;
                    seenPairs.add(num - k);
                }
            }
            uniqueNumbers.add(num);
        }
        return count;
    }
}