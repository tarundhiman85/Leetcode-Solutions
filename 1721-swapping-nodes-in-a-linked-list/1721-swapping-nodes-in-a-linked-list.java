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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode itr=head;
        int count=1;
        while(count++<k){
          itr=itr.next;      
        }
        ListNode first=itr;
        ListNode second=head;

        while(itr.next!=null){
          itr=itr.next;      
          second=second.next;
        }

        int temp=first.val;
        first.val=second.val;
        second.val=temp;
        
        return head;
    }
    /*
    Linked list
      i   j
    1-2-3-4-5
    stop the pointers at the just one position before
    i   j
    1-2-3-4-5
    get the next to next link for each pointers
    
    */
}