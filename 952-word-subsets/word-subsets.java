class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n = words1.length;
        int m = words2.length;

        List<String> list = new ArrayList<>();
        int[] freq = new int[26];

        for(String word: words2) {
            int[] temp = new int[26];

            for(char ch: word.toCharArray()) {
                temp[ch - 'a']++;

                freq[ch - 'a'] = Math.max(freq[ch - 'a'], temp[ch - 'a']);
            }
        }

        for(String word: words1) {
            int[] temp = new int[26];

            for(char ch: word.toCharArray()) {
                temp[ch - 'a']++;
            }

            if(isSubset(freq, temp)) {
                list.add(word);
            }
        }
        return list;
    }

    public boolean isSubset(int[] freq, int[] temp) {
        for(int i=0; i<26; i++) {
            if(temp[i] < freq[i]) {
                return false;
            }
        }
        return true;
    }
}
