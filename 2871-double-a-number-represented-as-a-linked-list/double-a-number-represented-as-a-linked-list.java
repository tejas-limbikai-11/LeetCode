/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last; 
    }

    public ListNode doubleIt(ListNode head) {     
        head = reverseList(head);
        ListNode curr = head;
        ListNode prev = null;
        int carry = 0;

        while(curr != null) {
            int newValue = curr.val * 2 + carry;
            curr.val = newValue % 10;
            carry = newValue / 10;
            prev = curr;
            curr = curr.next;
        }

        if(carry != 0) {
            ListNode newHead = new ListNode(carry);
            prev.next = newHead;
        }
        return reverseList(head);
    }
}