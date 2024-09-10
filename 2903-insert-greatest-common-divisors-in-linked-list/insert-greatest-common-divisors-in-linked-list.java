class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;

        while(curr != null && curr.next != null) {
            int a = curr.val;
            int b = curr.next.val;
            int result = gcd(a, b);

            ListNode nextNode = curr.next;
            curr.next = new ListNode(result);
            curr.next.next = nextNode;
            curr = nextNode;
        }
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