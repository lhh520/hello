package hot100;

public class 删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=head;
        int len=0;
        while (cur!=null){
            len++;
            cur=cur.next;
        }
        int p=len-n;
        cur=head;
        while (p>0){
            cur=cur.next;
            p--;
        }
        cur.next=cur.next.next;
        return dummy.next;
    }
}
