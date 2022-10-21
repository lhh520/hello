package backtrace;

public class 删除链表的倒数第N个结点 {
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        int len=0;
        ListNode cur=head;
        while (cur!=null){
            cur=cur.next;
            len++;
        }
        int l=len-n;
        cur=dummy;
        while (l>0){
            cur=cur.next;
            l--;
        }
        cur.next=cur.next.next;
        return dummy.next;
    }
}
