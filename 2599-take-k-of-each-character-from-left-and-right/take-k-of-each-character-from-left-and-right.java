class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int notDeletedWindow = 0;

        for(char ch: s.toCharArray()) {
            if(ch == 'a') countA++;
            if(ch == 'b') countB++;
            if(ch == 'c') countC++;
        }

        if(countA < k || countB < k || countC < k) return -1;

        int i = 0;
        int j = 0;

        while(j < n) {
            if(s.charAt(j) == 'a') countA--;
            else if(s.charAt(j) == 'b') countB--;
            else if(s.charAt(j) == 'c') countC--;

            //if deletion count of any character becomes less than k, then shrink the window and bring them back
            while(i <= j && (countA < k || countB < k || countC < k)) {
                if(s.charAt(i) == 'a') countA++;
                else if(s.charAt(i) == 'b') countB++;
                else if(s.charAt(i) == 'c') countC++;
                i++;
            }

            notDeletedWindow = Math.max(notDeletedWindow, j - i + 1);
            j++;
        }

        return n - notDeletedWindow;
    }
}