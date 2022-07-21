package 代码随想录二刷.链表;

import org.junit.Test;

public class 两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(-1,head);
        ListNode cur=dummy;
        ListNode pre=dummy;
        while (cur.next!=null&&cur.next.next!=null){
            ListNode temp=head.next.next;//记录下一组
            cur.next=head.next;
            head.next.next=head;
            head.next=temp;
            cur=head;
            head=head.next;
        }
        System.out.println(1);
        return dummy.next;
    }
    @Test
    public void test(){
        ListNode n4=new ListNode(4);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        swapPairs(n1);
    }
}
