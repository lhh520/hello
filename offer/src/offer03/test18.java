package offer03;

import org.junit.Test;

public class test18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=head;
        while(cur.val!=val&&cur!=null){
            pre=cur;
            cur=cur.next;
        }
        pre.next=cur.next;
        return dummy.next;
    }
    @Test
    public void test(){
        ListNode n4=new ListNode(9);
        ListNode n3=new ListNode(1,n4);
        ListNode n2=new ListNode(5,n3);
        ListNode n1=new ListNode(4,n2);
        ListNode temp=deleteNode(n1,4);
        while (temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }
    }
}
