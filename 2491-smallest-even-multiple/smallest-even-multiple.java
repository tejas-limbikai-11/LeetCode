class Solution {
    public int smallestEvenMultiple(int n) {
        for(int num=n; num<2*n; num++){
            if(num%2 == 0 && num%n == 0){
                return num;
            }
        }
        return 2*n;
    }
}