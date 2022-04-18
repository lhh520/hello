package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class offer70 {
    public ListNode sortList(ListNode head) {
        List<Integer>list=new ArrayList<>();
        ListNode cur=head;
        while (cur!=null)
        {
            list.add(cur.val);
            cur=cur.next;
        }
        //System.out.println(list.toString());
        Collections.sort(list);

        ListNode pre=new ListNode(0);
        cur=pre;
        for(int i=0;i<list.size();i++)
        {
            ListNode node=new ListNode(list.get(i));
            System.out.println(node.val);
            cur.next=node;
            cur=cur.next;
        }
        return pre.next;
    }
    @Test
    public void test()
    {
        ListNode n4=new ListNode(4);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        ListNode listNode=sortList(n1);
        ListNode cur=listNode;
        while (cur!=null)
        {
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
}
