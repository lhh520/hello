package list;

import org.junit.Test;

public class test203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(Integer.MAX_VALUE,head);
        ListNode pre=dummy;
        ListNode cur=head;
        while (cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
            }else {
                pre=cur;
            }
            cur=cur.next;
        }
        return dummy.next;
    }
    @Test
    public void test(){
        ListNode n4=new ListNode(3);
        ListNode n3=new ListNode(6,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        ListNode n=removeElements(n1,3);
        while (n!=null){
            System.out.println(n.val);
            n=n.next;
        }
    }
}
