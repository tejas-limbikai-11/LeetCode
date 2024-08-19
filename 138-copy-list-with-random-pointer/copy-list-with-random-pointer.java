class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        //Insert new nodes in existing linked list        
        Node curr = head;

        while(curr != null) {
            Node currNext = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = currNext;

            curr = currNext;
        }

        //Fill random pointers
        curr = head;

        while(curr != null) {
            if(curr.random == null) {
                curr.next.random = null;
            }
            else curr.next.random = curr.random.next;

            curr = curr.next.next;
        }

        Node newHead = head.next;
        Node newCurr = newHead;
        curr = head;

        while(curr != null && newCurr != null) {
            curr.next = (curr.next == null) ? null : curr.next.next;
            newCurr.next = (newCurr.next == null) ? null : newCurr.next.next;

            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
}