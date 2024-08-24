class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        int mid = len/2;
        long leftHalf = Long.parseLong(n.substring(0, (len % 2 == 0) ? mid : mid + 1)); 

        List<Long> possibleResults = new ArrayList<>();
        possibleResults.add(halfToPalindrome(leftHalf, len % 2 == 0));
        possibleResults.add(halfToPalindrome(leftHalf + 1, len % 2 == 0));
        possibleResults.add(halfToPalindrome(leftHalf - 1, len % 2 == 0));
        
        possibleResults.add((long) Math.pow(10, len - 1) - 1);   //Cases like 999
        possibleResults.add((long) Math.pow(10, len) + 1);       //Cases like 100..001

        long diff = Long.MAX_VALUE;
        long result = 0;
        long originalNum = Long.parseLong(n);

        for(long num: possibleResults) {
            if(num == originalNum) continue;

            if(Math.abs(num - originalNum) < diff) {
                diff = Math.abs(num - originalNum);
                result = num;
            } 
            else if(Math.abs(num - originalNum) == diff) {
                result = Math.min(result, num);
            }
        }
        return String.valueOf(result);
    }

    public long halfToPalindrome(long leftHalf, boolean isEven) {
        long resultNum = leftHalf;
        if(!isEven) {
            leftHalf = leftHalf / 10;
        }

        while(leftHalf > 0) {
            int digit = (int) leftHalf % 10;
            resultNum = (resultNum * 10) + digit;
            leftHalf /= 10;
        }
        return resultNum;
    }
}