class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int maxLength = 0;
        Set<String> set = new HashSet<>();

        for(int num: arr1) {
            String str = String.valueOf(num);
            for(int i=0; i<str.length(); i++) {
                set.add(str.substring(0, i+1));
            }
        }

        for(int num: arr2) {
            int count = 0;
            String str = String.valueOf(num);
            
            for(int i=0; i<str.length(); i++) {
                if(set.contains(str.substring(0, i+1))) {
                    count++;
                }
            }
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }
}