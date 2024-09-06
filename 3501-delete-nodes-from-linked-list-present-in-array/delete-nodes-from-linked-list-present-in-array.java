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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            if(set.contains(head.val)) {
                head = head.next;
            }
            else if(prev != null && set.contains(curr.val)) {
                prev.next = curr.next;
            }
            else prev = curr;            
            curr = curr.next;
        }
        return head;
    }
}