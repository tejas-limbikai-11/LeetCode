class Solution {
    public String toLowerCase(String s) {
        char[] ans = s.toCharArray();
        for(int i=0; i<ans.length; i++){
            if(ans[i] >= 'A' && ans[i] <= 'Z'){
                ans[i] = (char) (ans[i] + 32);
            }
        }
        return new String(ans);
    }
}