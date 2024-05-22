class Solution {
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        helper(s, new ArrayList<>(), result);
        return result;
    }

    public void helper(String s, List<String> subString, List<List<String>> result) {
        if(s == null || s.length() == 0) {
            result.add(new ArrayList<>(subString));
            return;
        }
        for(int i=1; i<=s.length(); i++) {
            String temp = s.substring(0, i);
            if(!isPalindrome(temp)) continue;

            subString.add(temp);
            helper(s.substring(i, s.length()), subString, result);
            subString.remove(subString.size() - 1);
        }
        return;
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}