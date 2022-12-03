package dp;

import backtrace.链表反转;

import java.util.*;

public class dd {
    public ListNode reverseList (ListNode head) {
        // write code here
        ListNode newHead=null;
        while (head!=null){
            ListNode cur=head.next;
            head.next=newHead;
            newHead=head;
            head=cur;
        }
        return newHead;
    }

    public static void main(String[] args) {
        int[]nums=new int[]{1,2,2,3,4,5,3,3,3,4,5};
        Stack<Integer>stack=new Stack<>();
        List<List<Integer>>lists=new ArrayList<>();
        for(int i=0;i< nums.length;){
            if(stack.isEmpty()||nums[stack.peek()]!=nums[i]){
                stack.add(i);
                i++;
            }else {
                List<Integer>list=new ArrayList<>();
                while (nums[stack.peek()]==nums[i]){
                    list.add(i);
                    i++;
                }
                list.add(stack.pop());
                Collections.sort(list);
                lists.add(new ArrayList<>(list));
            }
        }
        
        System.out.println(lists);
    }

}
