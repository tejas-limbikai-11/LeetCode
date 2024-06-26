class Solution {
    public boolean judgeSquareSum(int c) {
        if(c == 0) return true;
        long start = 0; 
        long end = (long) Math.sqrt(c);

        while(start <= end) {
            if(start*start + end*end == c) return true;
            else if(start*start + end*end > c) {
                end--;
            } 
            else start++;
        }
        return false;
    }
}