class Solution {
    public boolean lemonadeChange(int[] bills) {
        int change5 = 0;
        int change10 = 0;

        for(int bill: bills) {
            if(bill == 5) {
                change5 += 5;
            }
            else if(bill == 10) {
                if(change5 > 0) {
                    change5 -= 5;
                }
                else return false;
                change10 += 10;
            }
            else if(bill == 20) {
                int count = 0;

                if(change10 > 5) {
                    change10 -= 10;
                    count += 10;
                }
                while(change5 > 0 && count < 15) {
                    change5 -= 5;
                    count += 5;
                }
                if(count < 15) return false;
            }
        }
        return true;
    }
}