package 代码随想录;

import org.junit.Test;

public class 交换链表中的节点 {
    public ListNode swapNodes(ListNode head, int k) {
        int len=0;
        ListNode l1=head;
        ListNode l2=head;
        ListNode l3=head;
        int prev=k;
        while (prev-->1){
            l1=l1.next;
        }
        System.out.println(l1.val);
        while (l2!=null){
            len++;
            l2=l2.next;
        }

        int m=len-k;
        while (m-->0){
            l3=l3.next;
        }
        System.out.println(l3.val);
        int temp=l1.val;
        l1.val=l3.val;
        l3.val=temp;


        return head;
    }
    @Test
    public void test(){
        ListNode n5=new ListNode(5);
        ListNode n4=new ListNode(4,n5);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        System.out.println(swapNodes(n1,2));
    }
}
