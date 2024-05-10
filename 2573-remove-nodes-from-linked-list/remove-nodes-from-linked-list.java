class Solution {
    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;    
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public ListNode removeNodes(ListNode head) {
        head = reverseList(head);
        ListNode prev = null;
        ListNode curr = head;
        int max = 0;

        while(curr != null) {
            max = Math.max(max, curr.val);
            if(curr.val < max) {
                prev.next = curr.next;
                ListNode deleted = curr;
                curr = curr.next;
                deleted.next = null;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return reverseList(head);
    }
}