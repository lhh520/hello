package 新刷题;

import back.ListNode;

public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(0);
        ListNode node=dummy;
        while (list1!=null||list2!=null){
            int cur1=list1==null?Integer.MAX_VALUE:list1.val;
            int cur2=list2==null?Integer.MAX_VALUE:list2.val;
            ListNode cur=null;
            if(cur1<cur2){
                list1=list1.next;
                cur=new ListNode(cur1);
            }else {
                list2=list2.next;
                cur=new ListNode(cur2);
            }
            node.next=cur;
            node=node.next;
        }
        return dummy.next;
    }
}
