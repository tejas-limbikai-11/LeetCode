class Solution {
    public ListNode doubleIt(ListNode head) {     
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            int newVal = curr.val * 2;

            if(newVal < 10) {
                curr.val = newVal;
            } else if(prev != null) {
                curr.val = newVal % 10;
                prev.val += 1;
            } else {
                ListNode newHead = new ListNode(1);
                newHead.next = curr;
                curr.val = newVal % 10;
                head = newHead;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}