class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        if(spaces[idx] == 0) {
            sb.append(" ");
            idx++;
        }

        for(int i=0; i<s.length(); i++) {
            sb.append(s.charAt(i));
            if(idx < spaces.length && i+1 == spaces[idx]) {
                sb.append(" ");
                idx++;
            } 
        } 

        return sb.toString();
    }
}