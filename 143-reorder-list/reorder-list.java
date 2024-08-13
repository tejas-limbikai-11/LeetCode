class Solution {
    ListNode curr;

    public void reorderList(ListNode head) {
        curr = head;
        solve(head);        
    }

    public void solve(ListNode head) {
        if(head == null) return;
        solve(head.next);

        ListNode temp = curr.next;
        if(curr.next == null) return;
        else if(curr == head) {
            curr.next = null;
            return;
        }

        curr.next = head;
        head.next = (temp == head) ? null : temp;

        curr = temp;
    }
}