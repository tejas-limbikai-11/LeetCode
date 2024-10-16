class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int length = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
                length++;
            }
            else {
                // int idx = Collections.binarySearch(list, nums[i]);
                // if(idx < 0) idx = Math.abs(idx) - 1;
                
                int idx = binarySearch(list, nums[i]);
                list.set(idx, nums[i]);
            }
        }
        return length;
    }

    public int binarySearch(List<Integer> list, int key) {
        int low = 0;
        int high = list.size() - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(list.get(mid) == key) return mid;
            else if(list.get(mid) < key) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return high + 1;
    }
}