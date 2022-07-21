package 代码随想录二刷.链表;

import org.junit.Test;

public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        System.out.println(1);
        return pre;
    }
    @Test
    public void test(){
        ListNode n4=new ListNode(4);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        reverseList(n1);
    }
}
