package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test86 {
    public ListNode partition(ListNode head, int x) {
    List<ListNode> list1=new ArrayList<>();
    List<ListNode> list2=new ArrayList<>();
    ListNode t1=head;
    ListNode t2=head;
    ListNode pre=new ListNode(-1);
    pre.next=head;
    while (t1!=null)
    {       if(t1.val<x)
            list1.add(t1);
            t1=t1.next;
    }
    for(int i=0;i<list1.size();i++)
    {
        System.out.println(list1.get(i).val);
    }
    while (t2!=null)
    {
        if(t2.val>=x)
            list2.add(t2);
        t2=t2.next;
    }
    for(int i=0;i<list2.size();i++)
        {
            System.out.println(list2.get(i).val);
        }
    ListNode newhead=pre;
    ListNode cur=newhead;

    for(int i=0;i<list1.size();i++)
    {
         cur=list1.get(i);
         newhead.next=cur;
         newhead=newhead.next;
    }

        for(int i=0;i<list2.size();i++)
        {
            cur=list2.get(i);
            newhead.next=cur;
            newhead=newhead.next;
        }
        newhead.next=null;
        return pre.next;
    }
    @Test
    public void test()
    {   ListNode n6=new ListNode(2);
        ListNode n5=new ListNode(5,n6);
        ListNode n4=new ListNode(2,n5);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(4,n3);
        ListNode n1=new ListNode(1,n2);
        //System.out.println(1);
        ListNode nn=partition(n1,3);
        System.out.println(1);
    }
}
