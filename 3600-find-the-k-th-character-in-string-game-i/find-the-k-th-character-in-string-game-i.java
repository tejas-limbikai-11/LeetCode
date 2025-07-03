public class Solution {
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");
        
        while (word.length() < k) {
            int currentLength = word.length();
            StringBuilder newPart = new StringBuilder();
            
            for (int i = 0; i < currentLength; i++) {
                char nextChar = word.charAt(i);
                if (nextChar == 'z') {
                    newPart.append('a');
                } else {
                    newPart.append((char) (nextChar + 1));
                }
            }
            
            word.append(newPart);
        }
        
        return word.charAt(k - 1);
    }

}