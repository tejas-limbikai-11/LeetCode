class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(new StringBuilder(), n, 0, 0, result);
        return result;
    }

    public void generate(StringBuilder curr, int n, int open, int close, List<String> result) {
        if(curr.length() == 2 * n) {
            result.add(curr.toString());
            return;
        }

        if(open < n) {
            curr.append('(');
            generate(curr, n, open + 1, close, result);
            curr.deleteCharAt(curr.length() - 1);
        }

        if(open > close) {
            curr.append(')');
            generate(curr, n, open, close + 1, result);
            curr.deleteCharAt(curr.length() - 1);
        } 
    }
}