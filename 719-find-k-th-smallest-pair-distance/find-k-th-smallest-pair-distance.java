class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int l = 0;
        int r = nums[n-1] - nums[0];
        int result = 0;

        while(l <= r) {
            int mid = l + (r-l) / 2;
            int countPair = slidingWindow(nums, mid);

            if(countPair < k) {
                l = mid + 1;
            }
            else {
                result = mid;
                r = mid - 1;
            }
        }
        return result;
    }

    public int slidingWindow(int[] nums, int mid) {
        int i = 0;
        int j = 1;
        int pairCount = 0;

        while(j < nums.length) {
            while(nums[j] - nums[i] > mid) {
                i++;
            }

            pairCount += (j - i);
            j++;
        }
        return pairCount;
    }
}