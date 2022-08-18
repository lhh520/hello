package hot100;

public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add=0;
        ListNode dummy=new ListNode(0);
        ListNode ne=dummy;
        while (l1!=null&&l2!=null){
            int first=l1==null?0:l1.val;
            int second=l2==null?0:l2.val;
            ListNode cur=new ListNode((first+second+add)%10);
            add=(first+second+add)/10;
            ne.next=cur;
            ne=ne.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(add>0){
            ListNode temp=new ListNode(add);
            ne.next=temp;
        }
        return dummy.next;
    }
}
