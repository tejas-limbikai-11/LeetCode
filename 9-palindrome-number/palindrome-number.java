class Solution {
    public boolean isPalindrome(int x) {
        int p = x;
        int reverse = 0;

        while(x>0){
            int lastDigit = x % 10;
            reverse = (reverse * 10) + lastDigit;
            x = x/10;
        }

        if(p == reverse){
            return true;
        } else{
            return false;
        }
    }
}