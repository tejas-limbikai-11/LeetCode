class Solution {
    private int n;

    public TreeNode solve(String s, int[] idx, int depth) {
        if(idx[0] >= n) return null;

        int j = idx[0];
        while (j < n && s.charAt(j) == '-') {
            j++;
        }
        int dash = j - idx[0];

        if(depth != dash) return null;

        idx[0] += dash;

        int num = 0;
        while(idx[0] < n && Character.isDigit(s.charAt(idx[0]))) {
            num = (num * 10) + (s.charAt(idx[0]) - '0');
            idx[0]++;
        }

        TreeNode root = new TreeNode(num);
        root.left = solve(s, idx, depth + 1);
        root.right = solve(s, idx, depth + 1);

        return root;
    }

    public TreeNode recoverFromPreorder(String traversal) {
        n = traversal.length();
        int[] idx = {0};
        return solve(traversal, idx, 0);
    }
}
