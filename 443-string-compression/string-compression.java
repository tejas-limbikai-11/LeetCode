class Solution {
    public int compress(char[] chars) {
        StringBuilder str = new StringBuilder();
        for(int i=0; i<chars.length; i++){
            Integer count = 1;
            while(i<chars.length-1 && chars[i] == chars[i+1]){
                count++;
                i++;
            }
            str.append(chars[i]);
            if(count > 1){
                str.append(count);
            }
        }

        char[] ans = str.toString().toCharArray();
        for(int i=0; i<ans.length; i++){
            chars[i] = ans[i];
        }
        return ans.length;
    }
}