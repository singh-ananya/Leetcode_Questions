/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA= headA;
      ListNode currB= headB;
      int countA=0;
      int countB=0;
        
        while(currA.next!=null){
            currA=currA.next;
            countA++;
        }
        while(currB.next!=null){
            currB=currB.next;
            countB++;
        }
        
        while(countA>countB){
            headA=headA.next;
            countA--;
        }
        while(countB>countA){
            headB=headB.next;
            countB--;
        }
        
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        
      return headB; 
    }
}