package test2022;

import org.junit.Test;

public class 反转链表II {
    public ListNode reverseBetween (ListNode head, int m, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur1=dummy;
        ListNode cur2=dummy;
        while (m-->1){//前一个节点
            cur1=cur1.next;
        }
        //System.out.println(cur1.val);

        while (n-->0){
            cur2=cur2.next;
        }
       // System.out.println(cur2.val);
        //开始切分
        ListNode rightNode=cur2.next;
        cur2.next=null;
        //
        cur1.next=getList(cur1.next);

        while (cur1.next!=null){
            cur1=cur1.next;
        }
        cur1.next=rightNode;
        return dummy.next;

    }
    public ListNode getList(ListNode head){
        ListNode pre=null;
        while (head!=null){
            ListNode temp=head.next;
            head.next=pre;
            pre=head;
            head=temp;
        }
        return pre;
    }
    @Test
    public void test(){
        ListNode n5=new ListNode(5);
        ListNode n4=new ListNode(4,n5);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        ListNode node=reverseBetween(n1,2,4);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
}
