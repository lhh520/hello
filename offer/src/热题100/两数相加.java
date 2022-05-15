package 热题100;

import org.junit.Test;

public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addc=0;
        ListNode pre=new ListNode(0);
        ListNode cur=new ListNode(0);
        pre.next=cur;
        while (l1!=null||l2!=null){
            int node1=l1==null?0:l1.val;
            int node2=l2==null?0:l2.val;
            int nextNode=(node1+node2)%10;
            addc=(addc+node1+node2)/10;
            ListNode node=new ListNode(nextNode);
            cur.next=node;
            cur=cur.next;
            if(l1!=null)
            l1=l1.next;
            if(l2!=null)
            l2=l2.next;
        }
        if(addc>0){
            ListNode temp=new ListNode(addc);
            cur.next=temp;
        }
        return pre.next;
    }
    @Test
    public void test(){
        ListNode n4=new ListNode(1);
        ListNode n3=new ListNode(2,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        addTwoNumbers(n1,n2);
    }
}
