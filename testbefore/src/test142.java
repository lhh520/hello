public class test142
{
    public ListNode detectCycle(ListNode head) {
       if(head==null)
           return null;
       ListNode slow=head,fast=head;//初始化两个指针
        while(fast!=null)
        {
            slow=slow.next;
            if(fast.next!=null)
            {
                fast= fast.next.next;
            }
            else
                return null;
            if(fast==slow)//此时指针相遇
            {
                ListNode ptr=head;//
                while (ptr!=slow)
                {
                    ptr=ptr.next;
                    slow=slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}

