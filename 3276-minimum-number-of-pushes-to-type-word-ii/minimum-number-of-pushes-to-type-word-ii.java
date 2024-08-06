class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for(char ch: word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);

        int result = 0;
        int count = 1;
        int charAssigned = 0;

        for(int i=25; i>=0; i--) {
            if(freq[i] == 0) break;
            result += freq[i] * count;
            charAssigned++;
            if(charAssigned % 8 == 0) count++;
        }
        return result;
    }
}