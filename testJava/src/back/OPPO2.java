package back;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OPPO2 {
    public ListNode combineTwoDisorderNodeToOrder (ListNode node1, ListNode node2) {
        List<ListNode>list1=new ArrayList<>();
        List<ListNode>list2=new ArrayList<>();
        ListNode temp1=node1;
        ListNode temp2=node1;
        while (temp1!=null){
            list1.add(temp1);
            temp1=temp1.next;
        }
        while (temp2!=null){
            list1.add(temp2);
            temp2=temp2.next;
        }
        Collections.sort(list1, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        for(int i=0;i<list1.size();i++){
            cur.next=list1.get(i);
            cur=cur.next;
        }
        cur.next=null;
        return dummy.next;
    }
}
