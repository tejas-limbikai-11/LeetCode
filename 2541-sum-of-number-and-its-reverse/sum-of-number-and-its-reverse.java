class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        if(num == 0) return true;
        
        for(int i=0; i<num; i++) {
            if(i + reverse(i) == num) {
                return true;
            }
        }
        return false;
    }

    public int reverse(int num) {
        int reverseNum = 0;
        while(num > 0) {
            reverseNum = (reverseNum * 10) + (num % 10);
            num /= 10;
        }
        return reverseNum;
    }
}