public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;

        ListNode temp = headA;
        while(temp != null) {
            temp = temp.next;
            lengthA++;
        }        

        temp = headB;
        while(temp != null) {
            temp = temp.next;
            lengthB++;
        } 

        ListNode currA = headA;
        ListNode currB = headB;

        if(lengthA > lengthB) {
            int diff = lengthA - lengthB;
            while(diff-- > 0) {
                currA = currA.next;
            }
        }
        else if(lengthB > lengthA) {
            int diff = lengthB - lengthA;
            while(diff-- > 0) {
                currB = currB.next;
            }
        }

        while(currA != null && currB != null) {
            if(currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }
}