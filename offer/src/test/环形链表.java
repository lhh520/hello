package test;

import java.util.HashSet;
import java.util.Set;

public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode>set=new HashSet<>();
        while (head!=null){
            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head=head.next;
        }
        return false;
    }
}
