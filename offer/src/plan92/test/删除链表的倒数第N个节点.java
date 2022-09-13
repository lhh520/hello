package plan92.test;

import org.junit.Test;

public class 删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        int len=0;
        ListNode cur=head;
        while (cur!=null){
            cur=cur.next;
            len++;
        }
        int l=len-n;
        cur=dummy;

        while (l>0){
            cur=cur.next;
            l--;
        }

        cur.next=cur.next.next;

        System.out.println(cur.val);
        return dummy.next;
    }
    @Test
    public void test(){
        ListNode n5=new ListNode(4);
        ListNode n4=new ListNode(4,n5);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        removeNthFromEnd(n1,2);
    }
}
