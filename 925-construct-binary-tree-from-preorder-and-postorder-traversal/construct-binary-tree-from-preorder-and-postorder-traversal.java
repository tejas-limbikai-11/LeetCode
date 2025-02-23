class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return solve(0, 0, n-1, preorder, postorder);
    }

    public TreeNode solve(int preStart, int postStart, int preEnd, int[] preorder, int[] postorder) {
        if(preStart > preEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        if(preStart == preEnd) return root;

        int nextNode = preorder[preStart + 1];

        int j = postStart;
        while(postorder[j] != nextNode) {
            j++;
        }

        int numNodes = j - postStart + 1;

        root.left = solve(preStart + 1, postStart,  preStart + numNodes, preorder, postorder);
        root.right = solve(preStart + numNodes + 1, j + 1,  preEnd, preorder, postorder);

        return root;
    }
}
