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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if(list1.next == null) return null;
        ListNode prev = list1;
        ListNode curr = list1.next;
        int count = 1;
        while(curr.next != null && count != a)
        {
            curr = curr.next;
            prev = prev.next;
            count++;
        }
        while(curr.next != null && count != b)
        {
            curr = curr.next;
            count++;
        }
        ListNode last = list2;
        prev.next = list2;
        while(last.next != null)
        {
            last = last.next;
        }
        last.next = curr.next;
        return list1;
    }
}