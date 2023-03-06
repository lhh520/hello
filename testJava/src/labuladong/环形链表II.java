package labuladong;

public class 环形链表II {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                //return true;
                ListNode cur=head;
                while (cur!=slow){
                    cur=cur.next;
                    slow=slow.next;

                }
                return cur;
            }
        }
        return null;
    }
}
