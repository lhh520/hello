package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test328 {
    public ListNode oddEvenList(ListNode head) {
        List<ListNode>list=new ArrayList<>();
        ListNode cur=head;
        while (cur!=null)
        {
            list.add(cur);
            cur=cur.next;
        }

        //
        ListNode pre=new ListNode(-1);
        ListNode newhead=pre;
        for(int i=0;i<list.size();i=i+2)
        {
             ListNode temp=list.get(i);

             newhead.next=temp;
             newhead=temp;
        }
        for(int i=1;i<list.size();i=i+2)
        {
            ListNode temp=list.get(i);
            newhead.next=temp;
            newhead=temp;
        }
        newhead.next=null;
        return pre.next;
    }
    //2
    public ListNode oddEvenList1(ListNode head) {
        if(head==null)
            return head;
        ListNode evenHead=head.next;
        ListNode  odd=head,even=head.next;
        while (even!=null&&even.next!=null)
        {
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }

        @Test
    public void test()
    {   ListNode n5=new ListNode(5);
        ListNode n4=new ListNode(4,n5);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        ListNode nn=oddEvenList(n1);
        while (nn!=null)
        {
            System.out.println(nn.val);
            nn=nn.next;
        }
    }
}
