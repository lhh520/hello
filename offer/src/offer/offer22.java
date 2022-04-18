package offer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class offer22 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode>set=new HashSet<>();
        ListNode node=head;
        while (node!=null)
        {
            if(!set.add(node))
                return node;
            node=node.next;
        }
        return null;
    }
}
