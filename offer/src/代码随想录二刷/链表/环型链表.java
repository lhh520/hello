package 代码随想录二刷.链表;

public class 环型链表 {
    public ListNode detectCycle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                ListNode index1=fast;
                ListNode index2=head;
                while (index1!=index2){
                    index1=index1.next;
                    index2=index2.next;
                }
                return index2;
            }

        }
        return null;
    }
}
