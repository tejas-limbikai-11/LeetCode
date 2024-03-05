class Solution {
    public int minimumLength(String s) {
        if(s.length() == 1) {
            return 1;
        }
        int left = 0;
        int right = s.length()-1;

        while(left<right && s.charAt(left) == s.charAt(right)) {
            char ch = s.charAt(left);

            while(left<= right && ch == s.charAt(left)) {
                left++;
            }
            while(left<= right && ch == s.charAt(right)) {
                right--;
            }
        }

        return right - left + 1;
    }
}