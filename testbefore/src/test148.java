import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test148 {
    public ListNode sortList(ListNode head) {
    List<ListNode> temp=new ArrayList<ListNode>();
    ListNode cur=head;
    int len=0;
    while(cur!=null)
    {
        len++;
        temp.add(cur);
      cur=cur.next;
    }
    for(int i=0;i<len-1;i++)
    {
        for(int j=0;j<len-1-i;j++)
        {
            if(temp.get(j).val>temp.get(j+1).val)
            {
                int tt=temp.get(j).val;
                temp.get(j).val=temp.get(j+1).val;
                temp.get(j+1).val=tt;
            }

        }
    }

        return head;
    }
    @Test
    public void test()
    {
        ListNode l4=new ListNode(1);
        ListNode l3=new ListNode(2,l4);
        ListNode l2=new ListNode(6,l3);
        ListNode l1=new ListNode(3,l2);
        ListNode ans=sortList(l1);
        System.out.println(ans.val);
        System.out.println(ans.next.val);
        System.out.println(ans.next.next.val);
        System.out.println(ans.next.next.next.val);
    }

}
