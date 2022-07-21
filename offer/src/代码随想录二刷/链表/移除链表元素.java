package 代码随想录二刷.链表;


public class 移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=head;
        ListNode pre=dummy;
        while (cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
            }else {
                pre=cur;
            }
            cur=cur.next;
        }
        return dummy.next;
    }
}
