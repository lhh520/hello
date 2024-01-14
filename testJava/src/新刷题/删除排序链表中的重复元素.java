package 新刷题;

import back.ListNode;

public class 删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode cur=head;
        while (cur.next!=null){
            if(cur.val==cur.next.val){
                cur.next=cur.next.next.next;
            }else {
                cur=cur.next;//表示当前的值不再等于下一个值
            }
        }
        return head;
    }
}
