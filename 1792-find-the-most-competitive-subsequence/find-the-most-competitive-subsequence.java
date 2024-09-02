class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && nums[i] < nums[stack.peek()] && n - i + stack.size() > k) {
                stack.pop();
            }
            if(stack.size() < k) {
                stack.push(i);
            }
        }

        int[] result = new int[k];
        for(int i = k-1; i >= 0; i--) {
            int idx = stack.pop();
            result[i] = nums[idx];
        }
        return result;
    }
}