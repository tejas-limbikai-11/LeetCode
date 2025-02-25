class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int count = 0;
        int evenCount = 1;
        int oddCount = 0;
        int sum = 0;

        for(int i=0; i<n; i++) {
            sum += arr[i];
            if(sum % 2 == 0) {
                count += oddCount;
                evenCount++;
            }
            else {
                count += evenCount;
                oddCount++;
            }
            count %= 1000000007;
        }
        return count;
    }
}
