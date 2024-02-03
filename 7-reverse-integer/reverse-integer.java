class Solution {
    public int reverse(int x) {
        int num = Math.abs(x);

        int reverse = 0;

        while(num != 0){
            int lastDigit = num % 10;

            if(reverse > (Integer.MAX_VALUE - lastDigit)/10) {
                return 0;
            }

            reverse = (reverse * 10) + lastDigit;
            num = num/10;
        }

        if(x<0) {
            return (-reverse);
        }

        return reverse;
    }
}