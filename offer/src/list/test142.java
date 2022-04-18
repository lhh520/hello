package list;

public class test142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            //找到下一个点
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                ListNode l1=fast;
                ListNode l2=head;
                while (l1!=l2){
                    l1=l1.next;
                    l2=l2.next;
                }
                return l2;
            }

        }
        return null;
    }
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            if(fast==slow){
                return true;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return false;
    }
}
