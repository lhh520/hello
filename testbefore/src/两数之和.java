public class 两数之和 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        ListNode node1=l1;
        ListNode node2=l2;
        int next=0;
        while (node1!=null||node2!=null){
            int val1=node1==null?0:node1.val;
            int val2=node2==null?0:node2.val;
            ListNode newNode=new ListNode((next+val1+val2)%10);
            next=(next+val1+val2)/10;
            cur.next=newNode;
            cur=cur.next;
        }
        if(next!=0){
            ListNode node=new ListNode(next);
            cur.next=node;
        }
        return dummy.next;
    }
}
