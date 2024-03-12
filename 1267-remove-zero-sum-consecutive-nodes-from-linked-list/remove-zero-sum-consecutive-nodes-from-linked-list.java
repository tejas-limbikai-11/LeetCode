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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode temp = head;
        int sum = 0;

        while(temp != null) {
            sum += temp.val;
            if(sum == 0) {
                head = temp.next;
                sum = 0;
            }
            temp = temp.next;
        }
        if(head != null) {
            head.next = removeZeroSumSublists(head.next);
        }
        return head;
    }
}