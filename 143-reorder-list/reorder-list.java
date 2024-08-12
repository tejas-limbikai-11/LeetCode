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
    public void reorderList(ListNode head) {
        //find midnode
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse midnode to end
        ListNode rev = reverseLL(slow);

        ListNode curr = head;

        while(rev.next != null) {
            ListNode tempCurr = curr.next;
            curr.next = rev;

            ListNode tempRev = rev.next;
            rev.next = tempCurr;

            curr = tempCurr;
            rev = tempRev;
        }
        
    }

    public ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}