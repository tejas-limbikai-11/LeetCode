class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder rootToStart = new StringBuilder();
        StringBuilder rootToDest = new StringBuilder();

        findPath(root, startValue, rootToStart);
        findPath(root, destValue, rootToDest);

        int l = 0;
        while(l < rootToStart.length() && l < rootToDest.length()
        && rootToStart.charAt(l) == rootToDest.charAt(l)) {
            l++;
        }
        
        StringBuilder result = new StringBuilder();

        for(int i=0; i<rootToStart.length() - l; i++) {
            result.append('U');
        }
        for(int i=l; i<rootToDest.length(); i++) {
            result.append(rootToDest.charAt(i));
        }
        return result.toString();
    }

    public boolean findPath(TreeNode node, int target, StringBuilder path) {
        if(node == null) return false;
        if(node.val == target) return true;

        path.append('L');
        if(findPath(node.left, target, path)) return true;
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if(findPath(node.right, target, path)) return true;
        path.deleteCharAt(path.length() - 1);

        return false;
    }
}