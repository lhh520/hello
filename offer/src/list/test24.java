package list;

import org.junit.Test;

public class test24 {
    public ListNode swapPairs(ListNode head) {
        ListNode cur=head;
        ListNode dummy=new ListNode(-1,head);
        ListNode pre=dummy;

        while (cur!=null&&cur.next!=null){
            ListNode temp=cur.next.next;
            ListNode nextN=cur.next;
            pre.next=nextN;
            nextN.next=cur;
            cur.next=temp;
            pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }
    @Test
    public void test(){
        ListNode n4=new ListNode(4);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        ListNode n=swapPairs(n1);
        while (n!=null){
            System.out.println(n.val);
            n=n.next;
        }
    }
}
