class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int count = words.length;

        for(int i=0; i<words.length; i++) {
            for(char ch: brokenLetters.toCharArray()) {
                if(words[i].contains(Character.toString(ch))) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}