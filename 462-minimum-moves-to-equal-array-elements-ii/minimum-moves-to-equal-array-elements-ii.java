class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int smaller = 0;
        int larger = 0;
        int median = 0;

        for(int i=0; i<n; i++) {
            smaller = i;
            larger = n - i - 1;
            if(n % 2 == 1 && smaller == larger) median = nums[i];
            else if(smaller + 1 == larger) median = nums[i];
        }

        int moves = 0;
        for(int num: nums) {
            moves += Math.abs(num - median);
        }
        
        return moves;
    }
}