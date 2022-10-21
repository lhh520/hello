package dp;



public class 链表中环的入口节点 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        boolean flag=false;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                flag=true;
                break;
            }
        }
        if(flag){
            fast=head;
            while (fast!=slow){
                fast=fast.next;
                slow=slow.next;
            }
        }
        return fast;
    }
}
