package back;

public class 两数之和 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre1=l1;
        ListNode pre2=l2;
        int add=0;
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        while (pre1!=null||pre2!=null){
            int node1=pre1==null?0:pre1.val;
            int node2=pre2==null?0:pre2.val;
            int total=node1+node2+add;
            ListNode temp=new ListNode(total%10);
            cur.next=temp;
            cur=cur.next;
            add=total/10;
            if(pre1!=null){
                pre1=pre1.next;
            }
            if(pre2!=null){
                pre2=pre2.next;
            }
        }
        if(add!=0){
            ListNode temp=new ListNode(add);
            cur.next=temp;
            cur=cur.next;
        }
        return dummy.next;
    }
}
