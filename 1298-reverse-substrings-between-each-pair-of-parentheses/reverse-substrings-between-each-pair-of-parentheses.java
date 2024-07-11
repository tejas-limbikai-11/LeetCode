class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for(char ch: s.toCharArray()) {
            if(ch == ')') {
                while(stack.peek() != '(') {
                    queue.offer(stack.pop());
                }
                stack.pop();
                while(!queue.isEmpty()) {
                    stack.push(queue.poll());
                }
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch: stack) {
            sb.append(ch);
        }
        
        return sb.toString();
    }
}