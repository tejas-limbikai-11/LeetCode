class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        if(num == 0) return true;

        for(int i=1; i<num; i++) {
            StringBuilder sb = new StringBuilder(i + "");
            String str = sb.reverse().toString();
            int reverseI = Integer.parseInt(str);

            if(i + reverseI == num) return true;
        }
        return false;
    }
}