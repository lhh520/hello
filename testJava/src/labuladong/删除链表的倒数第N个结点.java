package labuladong;

public class 删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=head;
        int len=0;
        while (cur!=null){
            len++;
            cur=cur.next;
        }
        int temp=len-n;
        cur=dummy;
        while (temp-->=0){
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return dummy.next;
    }
}
