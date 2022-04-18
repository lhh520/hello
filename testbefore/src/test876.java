import org.junit.Test;

import java.util.List;

public class test876 {
    public ListNode middleNode(ListNode head) {
    if(head==null||head.next==null)
        return head;
    if(head.next.next==null)
        return head.next;
    ListNode fast=head;
    ListNode slow=head;
    while(fast.next.next!=null)
    {
        fast=fast.next.next;
        slow=slow.next;
    }
    return slow.next;
    }
    @Test
    public void test()
    {
        ListNode n4=new ListNode(4);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        System.out.println(middleNode(n1).val);
    }
}
