class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while(i < n) {
            int lettersCount = words[i].length();
            int j = i + 1;
            int spaceSlots = 0;

            while(j < n && lettersCount + spaceSlots + words[j].length() + 1 <= maxWidth) {
                lettersCount += words[j].length();
                spaceSlots++;
                j++;
            }

            int remainingSlots = maxWidth - lettersCount;

            int eachWordSpace = (spaceSlots == 0) ? 0 : remainingSlots / spaceSlots;
            int extraSpace = (spaceSlots == 0) ? 0 : remainingSlots % spaceSlots;

            if(j == n) {
                eachWordSpace = 1;
                extraSpace = 0;
            }

            result.add(getFinalLine(i, j, eachWordSpace, extraSpace, words, maxWidth));
            i = j;
        }
        return result;
    }

    public String getFinalLine(int i, int j, int eachWordSpace, int extraSpace, String[] words, int maxWidth) {
        StringBuilder sb = new StringBuilder();

        for(int k = i; k < j; k++) {
            sb.append(words[k]);

            if(k == j-1) continue;

            for(int space = 0; space < eachWordSpace; space++) {
                sb.append(" ");
            }

            if(extraSpace > 0) {
                sb.append(" ");
                extraSpace--;
            }
        }

        while(sb.length() < maxWidth) {
            sb.append(" ");
        }
        
        return sb.toString();
    }
}