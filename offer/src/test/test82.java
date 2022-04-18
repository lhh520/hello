package test;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test82 {
    public ListNode deleteDuplicates1(ListNode head)
    {
        if(head==null)
            return head;
        ListNode dummy=new ListNode(0,head);
        ListNode cur=dummy;
        while (cur.next!=null&&cur.next.next!=null)
        {
            if(cur.next.val==cur.next.next.val)
            {
                int x=cur.next.val;
                while (cur.next!=null&&cur.next.val==x)
                    cur.next=cur.next.next;
            }
            else
                cur=cur.next;
        }
        return dummy.next;
    }
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer>set1=new HashSet<>();
        Set<Integer>set2=new HashSet<>();
        ListNode pre=head;
        //
        while (pre!=null)
        {
            if(!set1.add(pre.val))
                set2.add(pre.val);
            pre=pre.next;
        }
        //set2中存储着已经重复的数字
        ListNode pre3=new ListNode(0,head);
        //pre3.next=head;
        ListNode cur=head;
        while (cur.next!=null&&cur.next.next!=null)
        {   if(set2.contains(cur.next.val))
            while (cur.next!=null&&set2.contains(cur.next.val))
            {
                cur.next=cur.next.next;

            }
          else
            cur=cur.next;
        }
        return pre3.next;
    }
    @Test
    public void test()
    {
        ListNode n4=new ListNode(1);
        ListNode n3=new ListNode(2,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
    }
}
