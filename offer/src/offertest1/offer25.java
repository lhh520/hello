package offertest1;

public class offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre=new ListNode(0);
        ListNode cur=pre.next;
        while (l1!=null&&l2!=null){
            ListNode temp=null;
            if(l1.val> l2.val){
                temp=l1;
                cur.next=temp;
                l1=l1.next;
            }else{
                temp=l2;
                cur.next=temp;
                l2=l2.next;
            }
            cur=cur.next;
        }
        if(l1==null)
        {
            cur.next=l2;
        }
        if(l1==null){
            cur.next=l1;
        }
        return pre;
    }

}
