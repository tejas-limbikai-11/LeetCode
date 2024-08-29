class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token: tokens) {
            if(token.equals("+")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first + second);
            }
            else if(token.equals("-")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            }
            else if(token.equals("*")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first * second);
            }
            else if(token.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first / second);
            }
            else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.peek();
    }
}