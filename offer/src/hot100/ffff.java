package hot100;

public class ffff {
    public int findMidNode (ListNode head) {
        // write code here
        ListNode fast=head,slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.val;
    }
}
