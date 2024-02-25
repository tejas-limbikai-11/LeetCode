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
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode mergedLL = new ListNode(-1);
        ListNode temp = mergedLL;

        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                temp.next = head1;
                head1= head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        //find midnode
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode midNode = slow;

        //call mergeSort for left and right half
        ListNode left = head;
        ListNode right = midNode.next;

        midNode.next = null;

        ListNode sortedLeft = sortList(left);
        ListNode sortedRight = sortList(right);

        //merge left and right half
        return merge(sortedLeft, sortedRight);
    }
}