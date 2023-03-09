/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        boolean isCycle=false;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            if(isCycle){
                fast=fast.next;
            }
            else{
                fast=fast.next.next;
            }
            //first time
            if(slow==fast && !isCycle){
                slow=head;
                isCycle=true;
            }
            if(slow==fast && isCycle){
                return slow;
            }
        }
        return null;
    }
}