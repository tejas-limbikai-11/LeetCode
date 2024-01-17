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
    class Node{
        Node head;
        String data;

        Node(String data){
            this.data = data;
            this.head = null;
        } 
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyNode = new ListNode();

        ListNode prevNode = dummyNode;
        ListNode currNode = head;

        while(currNode!= null && currNode.next != null){
            prevNode.next = currNode.next;
            currNode.next = prevNode.next.next;
            prevNode.next.next = currNode;

            prevNode = currNode;
            currNode = currNode.next;
        }
        return dummyNode.next;
    }
    public static void main(String args[]){
        Solution list = new Solution();

    }
}