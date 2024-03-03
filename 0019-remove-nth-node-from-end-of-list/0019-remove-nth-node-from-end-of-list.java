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
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        /*The crux of this problem is  
         just think you are removing from left
         so that you iterate the right pointer till n
         now the left pointer will move to exact previous point 
         //and we will assign the left pointer
             */
        ListNode left = head;
        ListNode right = head;

        for(int i=0; i<n; i++){
            right=right.next;
        }
        //forwarding left ensures we are removing the node from end
        if(right==null) return left.next;
        while(right.next!=null){
            right=right.next;
            left=left.next;
        }
        left.next=left.next.next;
        return head;
    }
}