class Solution {
    public boolean backspaceCompare(String s, String t) {
        return sb(s).equals(sb(t));
    }

    public String sb(String str) {
        StringBuilder sb = new StringBuilder();

        for(char ch: str.toCharArray()) {
            if(ch != '#') 
                sb.append(ch);

            else if(sb.length() != 0) 
                sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}