package test;

import java.util.ArrayList;
import java.util.List;

public class test147 {
    public ListNode insertionSortList(ListNode head) {
        List<ListNode>list=new ArrayList<>();
        ListNode pre=head;
        while (pre!=null)
        {
            list.add(pre);
            pre=pre.next;
        }
        int len=list.size();
        for(int i=1;i<len;i++)
        {
            ListNode temp=list.get(i);
            int j;
            for (j = i-1; j>=0&&list.get(j).val>temp.val ; j--) {
                 list.set(j+1,list.get(j));
            }
            list.set(j+1,temp);
        }
        ListNode dummy=new ListNode(0);
        ListNode cur=list.get(0);
        dummy.next=cur;
        for (int i = 1; i <len; i++) {
            ListNode temp=list.get(i);
            cur.next=temp;
            cur=cur.next;
        }
        cur.next=null;
        return dummy.next;
    }
    public void sort(int[]nums,int len)
    {
        for(int i=1;i<len;i++)
        {
            int temp=nums[i]; //取当前的值
            int j;
            for(j=i-1;j>=0&&nums[j]>temp;j--)
            {
                nums[j+1]=nums[j];//移动和比较
            }
            nums[j+1]=temp;
        }
    }
    public ListNode insertionSortList1(ListNode head) {
        // 1. 首先判断给定的链表是否为空，若为空，则不需要进行排序，直接返回。
        if(head == null){
            return head;
        }

        // 2. 链表初始化操作
        ListNode dummyHead = new ListNode(0); // 引入哑节点
        dummyHead.next = head;                // 目的是在head之前插入节点
        ListNode lastSorted = head;           // 维护lastSorted为链表已经排好序的最后一个节点并初始化
        ListNode curr = head.next;            // 维护curr 为待插入的元素并初始化

        // 3. 插入排序
        while(curr != null){
            if(lastSorted.val <= curr.val){     // 说明curr应该位于lastSorted之后
                lastSorted = lastSorted.next;   // 将lastSorted后移一位,curr变成新的lastSorted
            }
            else{                              // 否则,从链表头结点开始向后遍历链表中的节点
                ListNode prev = dummyHead;      // 从链表头开始遍历 prev是插入节点curr位置的前一个节点
                while(prev.next.val <= curr.val){ // 循环退出的条件是找到curr应该插入的位置
                    prev = prev.next;
                }
                // 以下三行是为了完成对curr的插入（配合题解动图可以直观看出）
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next; // 此时 curr 为下一个待插入的元素
        }
        // 返回排好序的链表
        return dummyHead.next;
    }
}
