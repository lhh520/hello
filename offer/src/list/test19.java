package list;

import org.junit.Test;

public class test19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=0;


        ListNode dummy=new ListNode(0,head);
        ListNode cur=dummy;
        ListNode temp=head;
        while (temp!=null){
            temp=temp.next;
            len++;
        }
        //System.out.println(len);
        for (int i = 1; i < len - n + 1; ++i) {
            cur = cur.next;
        }

        System.out.println("dd"+cur.val);
        cur.next=cur.next.next;
        return dummy.next;
    }
    @Test
    public void test(){
        ListNode n5=new ListNode(5);
        ListNode n4=new ListNode(4,n5);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        ListNode n=removeNthFromEnd(n1,2);
        while (n!=null){
            System.out.println(n.val);
            n=n.next;
        }
    }
}
