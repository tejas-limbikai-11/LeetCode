class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(new StringBuilder(), n, 0, result);
        return result;
    }

    public boolean isValid(StringBuilder sb) {
        int count = 0;
        String str = sb.toString();
        for(char ch: str.toCharArray()) {
            if(ch == '(') count++;
            else count--;

            if(count < 0) return false;
        }
        return count == 0;
    }

    public void generate(StringBuilder curr, int n, int length, List<String> result) {
        if(length == 2 * n) {
            if(isValid(curr)) {
                result.add(curr.toString());
            }
            return;
        }

        curr.append('(');
        generate(curr, n, length + 1, result);
        curr.deleteCharAt(curr.length() - 1);

        curr.append(')');
        generate(curr, n, length + 1, result);
        curr.deleteCharAt(curr.length() - 1);
    }
}