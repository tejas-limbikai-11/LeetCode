class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack();

        for(char c: s.toCharArray()) {
            if(!stack.isEmpty() && Math.abs(stack.peek() - c) == 32) {
                stack.pop();
            }
            else stack.push(c);
        }

        for(char c: stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}