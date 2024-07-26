class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int freq[] = new int[nums.length + 1];

        for(int num: nums) {
            if(freq[num] >= result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(freq[num]).add(num);
            
            freq[num]++;
        }

        return result;
    }
}