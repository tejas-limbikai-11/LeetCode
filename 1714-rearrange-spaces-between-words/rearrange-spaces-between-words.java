class Solution {
    public String reorderSpaces(String text) {
        String[] words = text.trim().split("\\s+");
        int n = text.length();
        int w = words.length;

        int spaces = 0;
        for (char ch : text.toCharArray()) {
            if (ch == ' ') spaces++;
        }

        if (w == 1) {
            StringBuilder sb = new StringBuilder(words[0]);
            for (int i = 0; i < spaces; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }

        int newSpace = spaces / (w - 1);
        int extraSpace = spaces % (w - 1);

        StringBuilder sb = new StringBuilder();

        int j = 0;
        for (String word : words) {
            sb.append(word);
            for (int i = 0; i < newSpace && j < (w - 1); i++) {
                sb.append(' ');
            }
            j++;
        }

        for (int i = 0; i < extraSpace; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}