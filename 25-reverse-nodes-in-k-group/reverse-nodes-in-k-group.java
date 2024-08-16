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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode prevNode = null;

        while(curr != null) {
            ListNode kthNode = findKthNode(curr, k);
            if(kthNode == null) {
                if(prevNode != null) {
                    prevNode.next = curr;
                }
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseLL(curr);
            if(curr == head) head = kthNode;
            else prevNode.next = kthNode;

            prevNode = curr;
            curr = nextNode;
        }
        return head;
    }

    public ListNode findKthNode(ListNode curr, int k) {
        while(curr != null && k > 1) {
            k--;
            curr = curr.next;
        }
        return curr;
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