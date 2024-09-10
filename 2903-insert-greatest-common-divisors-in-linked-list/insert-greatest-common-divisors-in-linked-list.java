class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
            
        ListNode temp = insertGreatestCommonDivisors(head.next);
        ListNode gcdNode = new ListNode(gcd(head.val, head.next.val));

        gcdNode.next = temp;
        head.next = gcdNode; 
        
        return head;
    }

    public int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}