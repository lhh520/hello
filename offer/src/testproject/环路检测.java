package testproject;

import java.util.HashSet;
import java.util.Set;

public class 环路检测 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode>set=new HashSet<>();
        while (head!=null){
            if(!set.add(head)){
               return head;
            }
            head=head.next;
        }
        return null;
    }
}
