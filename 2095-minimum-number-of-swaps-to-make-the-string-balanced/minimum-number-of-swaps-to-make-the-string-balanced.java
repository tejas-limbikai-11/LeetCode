class Solution {
    public int minSwaps(String s) {
        int imbalance = 0;
        int swap = 0;

        for(char ch: s.toCharArray()) {
            if(ch == '[') {
                imbalance++;
            }
            else if(ch == ']') {
                if(imbalance != 0) {
                    imbalance--;
                }
                else {
                    imbalance++;
                    swap++;
                }
            }
        }
        return swap;
    }
}