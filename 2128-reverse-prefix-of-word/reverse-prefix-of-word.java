class Solution {
    public String reversePrefix(String word, char ch) {
        boolean present = false;
        int idx = 0;

        for(int i=0; i<word.length(); i++) {
            if(ch == word.charAt(i)) {
                idx = i;
                present = true;
                break;
            }
        }

        if(present) {
            String toReverse = word.substring(0, idx+1);
            String reversed = new StringBuilder(toReverse).reverse().toString();
            return reversed + word.substring(idx+1, word.length());
        }
        else return word;
    }
}