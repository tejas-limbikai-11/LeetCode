class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean changed = true;
        while(changed) {
            changed = false;
            for(int i=0; i<sb.length()-1; i++) {
                if(Math.abs(sb.charAt(i) - sb.charAt(i+1)) == 32) {
                    sb.delete(i, i + 2);
                    changed = true;
                    break;
                }
            }
        }
        return sb.toString();
    }
}