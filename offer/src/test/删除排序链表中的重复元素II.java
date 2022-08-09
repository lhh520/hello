package test;

import java.util.*;

public class 删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        List<ListNode>list=new ArrayList<>();
        ListNode cur=head;
        HashMap<Integer,Integer>map=new HashMap<>();
        while (cur!=null){
            map.put(cur.val,map.getOrDefault(cur.val,0)+1);
            list.add(cur);
            cur=cur.next;
        }
        ListNode pre=new ListNode(-1);
        cur=pre;
        for(int i=0;i<list.size();i++){
            ListNode temp=list.get(i);
            if(map.get(temp.val)==1){
                cur.next=temp;
                cur=cur.next;
            }
        }
        if(cur.next!=null){
            cur.next=null;
        }
        return pre.next;
    }
    //
    public ListNode deleteDuplicates1(ListNode head){
        if(head==null){
            return null;
        }
        ListNode dummy=new ListNode(0,head);
        ListNode cur=dummy;
        while (cur.next!=null&&cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                int x=cur.next.val;
                while (cur.next!=null&&cur.next.val==x){
                    cur.next=cur.next.next;
                }
            }else {
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}
