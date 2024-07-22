class Solution {
    public int[] numberOfPairs(int[] nums) {
        int count[] = new int[101];
        for(int i: nums) {
            count[i]++;
        }
        int pairs = 0, leftover = 0;

        for(int i: count) {
            pairs += i / 2;
            leftover += i % 2;
        }
        return new int[] {pairs, leftover};
    }
}