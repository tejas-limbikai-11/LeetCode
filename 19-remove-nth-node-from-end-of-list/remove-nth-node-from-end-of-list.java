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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = 0;
        while(temp != null) {
            temp = temp.next;
            size++;
        }

        if(n == size) {
            return head.next;
        }

        int i = 0;
        int idx = size - n;
        ListNode prev = head;

        while(i < idx-1) {
            prev = prev.next;
            i++;
        } 

        prev.next = prev.next.next;
        return head;
    }
}