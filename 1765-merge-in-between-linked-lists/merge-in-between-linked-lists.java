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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int i=0;
        ListNode temp1 = list1;
        i = 0;
        while(i < b+1) {
            temp1 = temp1.next;
            i++;
        }
        ListNode temp2 = list2;
        while(temp2.next != null) temp2 = temp2.next;
        temp2.next = temp1;
        
        ListNode temp3 = list1;
        i=0;
        while(i < a-1) {
            temp3 = temp3.next;
            i++;
        } 
        temp3.next = list2;

        return list1;
    }
}