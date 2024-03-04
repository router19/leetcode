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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode temp =l1;
        int sizel1=0,sizel2=0;
        while(temp != null)
        {
            sizel1++;
            temp = temp.next;
        }
        temp = l2;
        while(temp != null)
        {
            sizel2++;
            temp = temp.next;
        }

        ListNode result = (sizel1 > sizel2) ? l1 : l2;
        temp = result;
        int carry = 0;
        ListNode lastNode= null;
        while(l1 != null && l2 != null){
            result.val = carry + l1.val + l2.val;
            carry = result.val /10;
            result.val = result.val % 10;
            l1 = l1.next;
            l2=l2.next;
            lastNode = result;
            result = result.next;   
        }

        while(result!=null)
        {
            result.val = carry + result.val;
            carry = result.val /10;
            result.val = result.val % 10;
            lastNode = result;
            result = result.next;
        }
        if(carry != 0)
            {
                lastNode.next = new ListNode(carry);
            }

        return temp;


    }
}