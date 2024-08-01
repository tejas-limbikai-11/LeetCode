class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String detail: details) {
            int one = detail.charAt(11) - '0';
            int two = detail.charAt(12) - '0';
            int age = one * 10 + two;
            if(age > 60) count++;
        }
        return count;
    }
}