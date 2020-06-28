package com.example.demo;

public class NO21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode preNode = newHead;
        ListNode head1 = l1;
        ListNode head2 = l2;

        while(head1 != null || head2 != null){
            if(head1 == null){
                preNode.next = head2;
                return newHead.next;
            }
            if(head2 == null){
                preNode.next = head1;
                return newHead.next;
            }
            if(head1.val <= head2.val){
                preNode.next = head1;
                preNode = head1;
                head1 = head1.next;
            }else{
                preNode.next = head2;
                preNode = head2;
                head2 = head2.next;
            }
        }

        return newHead.next;
    }
}
