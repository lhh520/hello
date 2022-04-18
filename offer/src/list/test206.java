package list;

import org.junit.Test;

public class test206 {
    public ListNode reverseList(ListNode head) {
        ListNode newhead=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode l1=cur.next;
            cur.next=newhead;
            newhead=cur;
            cur=l1;
        }
        return newhead;
    }
    @Test
    public void test(){
        ListNode n4=new ListNode(3);
        ListNode n3=new ListNode(6,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        ListNode n=reverseList(n1);
        while (n!=null){
            System.out.println(n.val);
            n=n.next;
        }
    }

}
