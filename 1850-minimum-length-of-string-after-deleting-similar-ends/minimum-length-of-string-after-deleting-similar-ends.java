class Solution {
    public int minimumLength(String s) {
        if(s.length() == 1) {
            return 1;
        }
        int left = 0;
        int right = s.length()-1;

        while(left<right) {
            if(s.charAt(left) != s.charAt(right)) {
                break;
            }

            if(s.charAt(left) == s.charAt(right)) {
                if(s.charAt(left+1) == s.charAt(left) && right-left>1) {
                    left++;
                } 
                else if(s.charAt(right-1) == s.charAt(right)  && right-left>1) {
                    right--;
                }
                else{
                    left++;
                    right--;
                }
            }
        }

        return right - left + 1;
    }
}