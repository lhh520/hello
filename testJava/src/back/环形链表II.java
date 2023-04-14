package back;

public class 环形链表II {
    public ListNode detectCycle(ListNode head) {
        //快慢指针
        ListNode fast=head;
        ListNode slow=head;
        while (fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                break;
            }
        }
        if(slow==fast){//存在环
            slow=head;
            while (slow!=fast){
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
        return null;
    }
}
