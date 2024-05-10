class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;

        while(curr != null) {
            st.push(curr);
            curr = curr.next;
        } 

        curr = st.pop();
        int max = curr.val;
        ListNode resultHead = new ListNode(max);

        while(!st.isEmpty()) {
            curr = st.pop();
            if(curr.val < max) continue;
            else {
                ListNode newNode = new ListNode(curr.val);
                newNode.next = resultHead;
                resultHead = newNode;
                max = curr.val;
            }
        }
        return resultHead;
    }
}