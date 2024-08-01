class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] directory = path.split("/");

        for(String dir: directory) {
            if(dir.equals("") || dir.equals(".")) continue;
            else if(!dir.equals("..")) {
                stack.push(dir);
            }
            else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s: stack) {
            sb.append("/").append(s);
        }

        if(sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}