class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        ListNode temp = head;
        int length = 0;
        while(temp != null) {
            temp = temp.next;
            length++;
        }

        int partSize = length / k;
        int extra = length % k;
        
        ListNode curr = head;

        for(int i=0; i<k; i++) {
            ListNode partHead = curr;

            int currSize = partSize + (i < extra ? 1 : 0);

            int count = 1;
            while(curr != null && count < currSize) {
                curr = curr.next;
                count++;
            }

            if(curr != null) {
                ListNode nextNode = curr.next;
                curr.next = null;
                curr = nextNode;
            }

            result[i] = partHead;
        }
        return result;
    }
}