package Nc;

import org.junit.Test;

public class Nc78 {
    public ListNode ReverseList(ListNode head) {
    ListNode pre=new ListNode(-1);
    pre.next=head;
    ListNode newhead=null,cur=head;
    //反转链表 一定记得要新建临时链表值
    while(cur!=null)
    {
        ListNode temp=cur.next;
        cur.next=newhead;
        newhead=cur;
        cur=temp;
    }
    return newhead;
    }
    @Test
    public void test()
    {
        ListNode n4=new ListNode(4);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        ListNode ans=ReverseList(n1);
        while (ans!=null)
        {
            System.out.println(ans.val);
            ans=ans.next;
        }
    }
}
