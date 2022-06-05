package test;

public class 链表求和 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addSum=0;
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while (l1!=null||l2!=null||addSum!=0){//两者中有一个不为空，代表可以继续下去
            int node1=l1==null?0:l1.val;
            int node2=l2==null?0:l2.val;
            int sum=node1+node2+addSum;//表示最终的和
            ListNode temp=new ListNode(sum%10);//表示取余数
            addSum=sum/10;//表示sum/10
            cur.next=temp;
            cur=cur.next;
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
