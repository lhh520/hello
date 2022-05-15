package 热题100;

import org.junit.Test;

public class 删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode cur=head;
        int count=0;
        while (cur!=null){
            count++;
            cur=cur.next;
        }

        int temp=count-n;
        cur=pre;
        while (temp>0){
            temp=temp-1;
            cur=cur.next;
        }

        cur.next=cur.next.next;

        return pre.next;
    }
    @Test
    public void test(){
//        ListNode n4=new ListNode(1);
//        ListNode n3=new ListNode(2,n4);
        ListNode n2=new ListNode(2);
        ListNode n1=new ListNode(1,n2);
        removeNthFromEnd(n1,2);
    }
}
