class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(postorder[i], i);
        }
        return solve(0, 0, n-1, preorder, postorder, map);
    }

    public TreeNode solve(int preStart, int postStart, int preEnd, int[] preorder, int[] postorder, Map<Integer, Integer> map) {
        if(preStart > preEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        if(preStart == preEnd) return root;

        int nextNode = preorder[preStart + 1];

        int j = map.get(nextNode);

        int numNodes = j - postStart + 1;

        root.left = solve(preStart + 1, postStart,  preStart + numNodes, preorder, postorder, map);
        root.right = solve(preStart + numNodes + 1, j + 1,  preEnd, preorder, postorder, map);

        return root;
    }
}
