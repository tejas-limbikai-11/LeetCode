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
        
        String str = "";
        while(!stack.isEmpty()) {
            str = "/" + stack.pop() + str;
        }

        if(str.length() == 0) str = "/";
        return str;
    }
}