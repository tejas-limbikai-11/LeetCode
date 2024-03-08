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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            size++;
        }

        int n = 0;
        if(k > size) n = k % size;
        else n = k;

        for(int i=0; i<n; i++) {
            ListNode tail = head;
            ListNode prev = null;
            while(tail.next != null) {
                prev = tail;
                tail = tail.next;
            }
            tail.next = head;
            head = tail;
            prev.next = null;
        }
        
        return head;
    }
}