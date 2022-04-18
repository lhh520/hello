import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test1290 {
    public int getDecimalValue(ListNode head) {
        List<Integer>list=new ArrayList<>();
        while (head!=null)
        {
            list.add(head.val);
            head=head.next;
        }
        int sum=0;
        for(int i=0;i<list.size();i++)
        {
            sum=sum*2+list.get(i);
        }
        //System.out.println(list.toString());
        return sum;
    }
    @Test
    public void test()
    {
        ListNode n4=new ListNode(1);
        ListNode n3=new ListNode(1,n4);
        ListNode n2=new ListNode(0,n3);
        ListNode n1=new ListNode(1,n2);
        System.out.println(getDecimalValue(n1));
    }
}
