package plan92.test;

import java.util.List;

public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre1=l1;
        ListNode pre2=l2;
        int add=0;
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while (l1!=null||l2!=null){
            int val1=l1==null?0:l1.val;
            int val2=l2==null?0:l2.val;
            int total=val1+val2+add;
            ListNode tmp=new ListNode(total%10);
            add=total/10;
            cur.next=tmp;
            cur=cur.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(add!=0){
            ListNode tmp=new ListNode(add);
            cur.next=tmp;
            cur=cur.next;
        }
        return dummy.next;
    }
}
