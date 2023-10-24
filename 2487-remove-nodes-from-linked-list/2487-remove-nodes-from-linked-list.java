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
    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode removeNodes(ListNode head) {
         Stack<Integer> st = new Stack<>();
        ListNode curr = head;
        while(curr!=null)
        {
            while(!st.isEmpty() && st.peek() < curr.val)
            {
                st.pop();
            }
            st.push(curr.val);
            curr = curr.next;
        }
        head = new ListNode(-1);
        curr = head;
        while(!st.isEmpty())
        {
            curr.next = new ListNode(st.pop());
            curr = curr.next;
        }
        return reverseLinkedList(head.next);
    }
}