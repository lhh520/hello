package 代码随想录;

public class 链表最大孪生和 {
    public int pairSum(ListNode head) {
        ListNode fast=head,slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode pre=null;
        ListNode p=slow;
        while (p!=null){
            ListNode tmp=p.next;
            p.next=pre;
            pre=p;
            p=tmp;
        }
        int ans=0;
        ListNode q;
        for(p=head,q=pre;q!=null;p=p.next,q=q.next){
            ans=Math.max(ans,p.val+q.val);
        }
        return ans;
    }
}
