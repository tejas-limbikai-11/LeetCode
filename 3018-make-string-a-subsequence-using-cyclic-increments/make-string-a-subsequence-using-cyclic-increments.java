class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        if(str1.length() < str2.length()) return false;
        int i = 0;
        int j = 0;

        while(i < str1.length() && j < str2.length()) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(j);
            int diff = char2 - char1;

            if(diff == 0 || diff == 1 || diff + 25 == 0) {  //to handle z, a case
                j++; 
            }
            i++;
        }

        return j == str2.length();
    }
}