class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int nge[] = new int[nums1.length];

        for(int num: nums2) {
            while(!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int i = 0;
        for(int num: nums1) {
            nge[i++] = map.getOrDefault(num, -1);
        }
        return nge;
    }
}