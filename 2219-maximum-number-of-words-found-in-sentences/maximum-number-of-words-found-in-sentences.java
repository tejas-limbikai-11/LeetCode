class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;
        for(int i=0; i<sentences.length; i++){
            char[] charArray = sentences[i].toCharArray();
            int count = 0;
            for(int j=0; j<charArray.length; j++){
                if(charArray[j] == ' '){
                    count++;
                }
            }
            if(count > maxWords){
                maxWords = count;
            }
        }

        maxWords += 1;
        return maxWords;
    }
}