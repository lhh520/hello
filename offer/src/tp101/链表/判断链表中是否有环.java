package tp101.链表;

public class 判断链表中是否有环 {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head,slow=head;
        while (fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}
