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
    public ListNode partition(ListNode head, int x) {
      ListNode small=new ListNode();
      ListNode smallptr=small;
      
      ListNode large=new ListNode();
        ListNode largeptr=large;
        while(head!=null){
            if(head.val<x){
                smallptr.next=head;
                smallptr=smallptr.next;
                head=head.next;
            }else{
                largeptr.next=head;
                largeptr=largeptr.next;
                head=head.next;
            }
        }
        largeptr.next=null;
        smallptr.next=large.next;
        return small.next;
        
    }
}