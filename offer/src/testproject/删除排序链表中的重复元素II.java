package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        List<ListNode>list=new ArrayList<>();
        ListNode cur=head;
        HashMap<Integer,Integer>map=new HashMap<>();
        while(cur!=null){
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
    @Test
    public void test(){
        ListNode n5=new ListNode(3);
        ListNode n4=new ListNode(2,n5);
        ListNode n3=new ListNode(1,n4);
        ListNode n2=new ListNode(1,n3);
        ListNode n1=new ListNode(1,n2);
        ListNode nn=deleteDuplicates(n1);
        while (nn!=null){
            System.out.println(nn.val);
            nn=nn.next;
        }
    }
}
