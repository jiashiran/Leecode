package com;

/**
 * Author: jiashiran
 * Date: 2022/11/10 4:50 PM
 */
public class n1 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        int nextV = 0;
        ListNode cur = null;
        while (l1 != null || l2 != null){
            int v = 0;
            if(l1 != null){
                v += l1.val;
            }
            if(l2!=null){
                v += l2.val;
            }
            v = v + nextV;
            if(v >= 10){
                v = v - 10;
                nextV = 1;
            }else {
                nextV = 0;
            }

            if(head == null){
                head = new ListNode(v);
                cur = head;
            }else {
                cur.next = new ListNode(v);
                cur = cur.next;
            }


            if(l1 != null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }

        if(nextV == 1){
            cur.next = new ListNode(1);
        }


        return head;
    }

    public static void testAddTwoNumbers() {
        //343
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        //678
        ListNode l2 = new ListNode(6);
        l2.next = new ListNode(7);
        l2.next.next = new ListNode(8);
        n1 n = new n1();
        //9121
        ListNode l3 = n.addTwoNumbers(l1,l2);

        while (l3 != null){
            System.out.print(l3.val+",");
            l3 = l3.next;
        }

    }

}



class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
