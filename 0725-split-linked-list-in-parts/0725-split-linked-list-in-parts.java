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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cur = head;
        ListNode[] answer = new ListNode[k];
        int ptr = 0, listLength = 0;

        // Calculate the length of the linked list
        while (cur != null) {
            listLength++;
            cur = cur.next;
        }

        // Calculate the extra elements in some parts
        int extra = listLength % k;
        // Calculate the base length for each part
        int partLength = listLength / k;
        cur = head;

        while (cur != null) {
            answer[ptr++] = cur;
            // Calculate the length of the current part
            int currentLength = partLength - 1 + ((extra-- > 0) ? 1 : 0);

            // Move the current pointer to the end of the current part
            for (int i = 0; i < currentLength; i++)
                cur = cur.next;

            // Disconnect the current part from the next part
            ListNode temp = cur.next;
            cur.next = null;
            cur = temp;
        }
        return answer;
    }
}