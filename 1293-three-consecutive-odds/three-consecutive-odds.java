class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int odds = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] % 2 != 0){
                odds++;
                if(odds == 3) return true;
            }
            else odds = 0;
        }
        return false;
    }
}