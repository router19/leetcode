package linkedlist;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
        while(l1 != null && l2 != null){
            result.val = carry + l1.val + l2.val;
            carry = result.val /10;
            result.val = result.val % 10;
            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }

        while(result != null)
        {
            result.val = carry + result.val;
            carry = result.val /10;
            result.val = result.val % 10;
            result = result.next;
        }
        if(carry != 0)
        {
            result.next = new ListNode(carry);
        }

        return temp;

    }
    public static void main(String[] args) {
        int i =12;

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);


//        System.out.println(i%10 + "  " + i/10);
        System.out.println(addTwoNumbers(l1,l2));
    }

}
