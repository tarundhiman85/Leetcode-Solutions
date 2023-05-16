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
      public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode newHead=new ListNode(0);
        ListNode curr=newHead;
        ListNode first=head;
        ListNode second=head.next;
        while(first!=null && second!=null){
            ListNode temp=second.next;
            curr.next=second;
            curr.next.next=first;
            curr=first;
            first=temp;
            if(first!=null)
                second=temp.next;
            
        }
        if(first==null)
            curr.next=null;
        else
            curr.next=first;
		return newHead.next;
    }
}