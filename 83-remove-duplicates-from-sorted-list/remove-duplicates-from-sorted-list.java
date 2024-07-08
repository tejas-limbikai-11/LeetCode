class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            if(prev != null && prev.val == curr.val) 
                prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return head;
    }
}