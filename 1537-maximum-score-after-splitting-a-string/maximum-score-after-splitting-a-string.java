class Solution {
    public int maxScore(String s) {
        int oneCount = 0;
        int zeroCount = 0;

        for(char ch: s.toCharArray()) {
            if(ch == '0') zeroCount++;
            else oneCount++;
        }

        int onesTillNow = 0;
        int zerosTillNow = 0;
        int result = 0;

        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '0') zerosTillNow++;
            else onesTillNow++;

            result = Math.max(result, zerosTillNow + (oneCount - onesTillNow));
        }
        return result;
    }
}
