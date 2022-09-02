package backtrace;
import java.util.*;
public class test98888 {
    public ListNode combineTwoDisorderNodeToOrder (ListNode node1, ListNode node2) {
        // write code here
        List<ListNode>list=new ArrayList<>();
        while (node1!=null){
            list.add(node1);
            node1=node1.next;
        }
        while (node2!=null){
            list.add(node2);
            node2=node2.next;
        }
        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        for(int i=0;i<list.size();i++){
             cur.next=list.get(i);
             cur=cur.next;
        }
        cur.next=null;
        return dummy.next;
    }
}

 class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }