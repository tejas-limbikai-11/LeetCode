class Solution {
    public int numRabbits(int[] answers) {
        int[] count = new int[1001];
        for(int answer: answers) {
            count[answer]++;
        }

        int result = 0;

        for(int i = 0; i <= 1000; i++) {
            int groupSize = i + 1;
            int groups = (int) Math.ceil((double) count[i] / groupSize);
            result += (groups * groupSize);
        }
        return result;
    }
}