package Hot100_2;



public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode head=dummy.next;
        int next=0;
        while (l1!=null||l2!=null){
            int val1=l1==null?0:l1.val;
            int val2=l2==null?0:l2.val;
            int cur=(val1+val2+next)%10;
            next=(val1+val2+next)/10;
            ListNode temp=new ListNode(cur);
            System.out.println(temp);
            head=temp;
            head=head.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        return dummy.next;
    }
}
