class Solution {
    public List<String> commonChars(String[] words) {
        ArrayList<String> list = new ArrayList<>();
        
        int count[] = new int[26];
        fillCount(words[0], count);

        for(int i=1; i<words.length; i++) {
            int temp[] = new int[26];
            fillCount(words[i], temp);

            for(int j=0; j<26; j++) {
                count[j] = Math.min(count[j], temp[j]);
            }
        }

        for(int i=0; i<26; i++) {
            int c = count[i];
            while(c-- > 0) {
                list.add(String.valueOf((char) (i + 'a')));
            }
        }
        return list;
    }

    public void fillCount(String word, int count[]) {
        for(char ch: word.toCharArray()) {
            count[ch - 'a']++;
        }
    }
}