class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for(char ch: s.toCharArray()) {
            sb.append(ch - 'a' + 1);
        }

        int sum = 0;

        while(k-- > 0) {
            sum = 0;
            for(int i=0; i<sb.length(); i++) {
                sum += (sb.charAt(i) - '0');
            }
            sb.setLength(0);
            sb.append(String.valueOf(sum));
        }
        return sum;
    }
}