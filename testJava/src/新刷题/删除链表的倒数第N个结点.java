package 新刷题;

import back.ListNode;

public class 删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //双指针法
        ListNode fast=head;
        ListNode dummy=new ListNode(0,head);
        ListNode slow=dummy;
        for (int i = 0; i < n; ++i) {
            fast=fast.next;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
}
