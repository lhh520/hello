package backtrace;

public class 链表反转 {
    class ListNode{
        int val;
        ListNode next;
    }
    public ListNode reverseList(ListNode head) {
        ListNode newHead=null;
        while (head!=null){
            ListNode cur=head.next;
            head.next=newHead;
            newHead=head;
            head=cur;
        }
        return newHead;
    }
}
