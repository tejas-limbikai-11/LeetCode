class Solution {
    public int[] dailyTemperatures(int[] temp) {
       int n = temp.length;
       Stack<Integer> stack = new Stack<>();
       int result[] = new int[n];

       for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
       }

       return result;
    }
}