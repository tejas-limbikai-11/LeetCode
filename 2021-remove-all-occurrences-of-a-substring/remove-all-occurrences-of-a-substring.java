class Solution {
    public String removeOccurrences(String s, String part) {
        int m = s.length();
        int n = part.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<m; i++) {
            stack.push(s.charAt(i));

            if(stack.size() >= n && checkIfMatch(stack, part, n)) {
                for(int j=0; j<n; j++) {
                    stack.pop();
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public boolean checkIfMatch(Stack<Character> st, String part, int n) {
        Stack<Character> temp = new Stack<>();
        temp.addAll(st);

        for(int i=n-1; i>=0; i--) {
            if(temp.peek() != part.charAt(i)) {
                return false;
            }
            temp.pop();
        }
        return true;
    }
}
