class Solution {
    public boolean backspaceCompare(String s, String t) {
        return stackSolution(s).equals(stackSolution(t));
    }

    public String stackSolution(String str) {
        Stack<Character> st = new Stack<Character>();

        for(char ch: str.toCharArray()) {
            if(ch != '#') st.push(ch);

            else if(!st.isEmpty()) st.pop();
        }
        return st.toString();
    }
}