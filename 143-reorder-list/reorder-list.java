class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while(curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        int k = stack.size()/2;
        curr = head;

        while(k-- > 0) {
            ListNode topNode = stack.pop();
            ListNode temp = curr.next;
            curr.next = topNode;
            topNode.next = temp;
            curr = temp;
        }
        curr.next = null;
    }
}