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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        if (head == null || head.next == null || head.next.next == null) 
            return ans;

        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;
        int minDist = Integer.MAX_VALUE;
        int firstCritical = -1;
        int lastCritical = -1;

        while(curr.next != null) {
            if((prev.val > curr.val && curr.next.val > curr.val) 
                || (prev.val < curr.val && curr.next.val < curr.val)) {

                if(firstCritical == -1) firstCritical = index;
                else minDist = Math.min(minDist, index - lastCritical);
                lastCritical = index;
            } 
            prev = curr;
            curr = curr.next;
            index++;
        }
        if (firstCritical != -1 && lastCritical != -1 && firstCritical != lastCritical) {
            ans[0] = minDist;
            ans[1] = lastCritical - firstCritical;
        }
        return ans;
    }
}