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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        int sum = 0;
        int carry = 0;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode head1 = l1, head2 = l2;

        while(head1 != null) {
            s1.push(head1.val);
            head1 = head1.next;
        }

        while(head2 != null) {
            s2.push(head2.val);
            head2 = head2.next;
        }

        while(!s1.isEmpty() || !s2.isEmpty()) {
            if(!s1.isEmpty()) {
                sum += s1.pop();
            }
            if(!s2.isEmpty()) {
                sum += s2.pop();
            }

            ans.val = sum % 10;
            carry = sum / 10;
            
            ListNode newNode = new ListNode(carry);
            newNode.next = ans;
            ans = newNode;
            sum = carry;
        }
        return (carry == 0) ? ans.next : ans;
    }
}