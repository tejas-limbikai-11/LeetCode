class Solution {
    public String makeGood(String s) {
        if(s.length() < 2) return s;
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()) {
            if(sb.length() > 0 && Math.abs(sb.charAt(sb.length()-1) - c) == 32) {
                sb.deleteCharAt(sb.length()-1);
            }
            else sb.append(c);
        }
        return sb.toString();
    }
}