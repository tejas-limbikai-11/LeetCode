class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(-1);
        ListNode largeHead = new ListNode(-1);
        ListNode smallPointer = smallHead;
        ListNode largePointer = largeHead;
        ListNode temp = head;

        while(temp != null) {
            if(temp.val < x) {
                smallPointer.next = temp;
                smallPointer = smallPointer.next;
            }
            else {
                largePointer.next = temp;
                largePointer = largePointer.next;
            }
            temp = temp.next;
        }
        smallPointer.next = largeHead.next;
        largePointer.next = null;
        return smallHead.next;
    }
}