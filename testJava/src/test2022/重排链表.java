package test2022;

import java.util.ArrayList;
import java.util.List;

public class 重排链表 {
    public void reorderList(ListNode head){
        if(head==null){
            return;
        }
        List<ListNode>list=new ArrayList<>();
        ListNode node=head;
        while (node!=null){
            list.add(node);
            node=node.next;
        }
        int i=0,j=list.size()-1;
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while (i<j){
            list.get(i).next=list.get(j);
            i++;
            if(i==j){
                break;
            }
            list.get(j).next=list.get(i);
            j--;
        }
        list.get(i).next=null;
    }
}
