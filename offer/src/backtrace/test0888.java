package backtrace;


import java.util.*;
public class test0888 {
    public ListNode mergeNode (ListNode head) {
        // write code here
        List<Integer>list=new ArrayList<>();
        while (head!=null){
            list.add(head.val);
        }
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        for(int i=0;i<list.size();i+=2){
            ListNode uu=new ListNode(list.get(i)+list.get(i+1));
            cur.next=uu;
            cur=cur.next;
        }
        return dummy.next;
    }
    public class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }
}

