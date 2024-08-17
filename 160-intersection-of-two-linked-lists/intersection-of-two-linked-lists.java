public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;        

        while(a != b) {
            a = a.next;
            b = b.next;

            if(a == b) return a;

            if(a == null) a = headB;
            if(b == null) b = headA;
        }
        return a;
    }
}