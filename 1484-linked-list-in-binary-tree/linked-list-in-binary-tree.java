class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) return false;

        return checkEqual(head, root) 
            || isSubPath(head, root.left)
            || isSubPath(head, root.right);
    }

    public boolean checkEqual(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null) return false;

        if(root.val != head.val) return false;

        return checkEqual(head.next, root.left)
            || checkEqual(head.next, root.right);
    }
}