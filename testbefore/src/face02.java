import org.junit.Test;

public class face02 {
    public int kthToLast(ListNode head, int k) {
        ListNode pre=head;
        int len=0;
        while (pre!=null)
        {
            pre=pre.next;
            len++;
        }
        System.out.println(len);
        ListNode cur=head;
        int m=len-k;
        while(m!=0)
        {
            m--;
            cur=cur.next;
        }
        return cur.val;
    }
    @Test
    public void test()
    {
        ListNode n4=new ListNode(4);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        int n=kthToLast(n1,2);
        System.out.println(n);
    }
}
