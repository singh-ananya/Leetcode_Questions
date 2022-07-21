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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null)
            return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode curr=dummy;
        ListNode prev=null;
        for(int i=0;i<left;i++){
            prev=curr;
            curr=curr.next;
        }
        ListNode currR=curr;
        ListNode prevR=prev;
        for(int i=left;i<=right;i++){
            ListNode next=currR.next;
            currR.next=prevR;
            
            prevR=currR;
            currR=next;
        }
        prev.next=prevR;
        curr.next=currR;
        
        return dummy.next;
        
    }
}