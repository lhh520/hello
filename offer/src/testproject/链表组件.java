package testproject;

import org.junit.Test;

import java.util.*;

public class 链表组件 {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        System.out.println(1);
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            if (set.contains(list.get(i)) && (i + 1 == list.size() || !set.contains(list.get(i + 1)))) {
                ans++;
            }
        }
        return ans;
    }
    @Test
    public void test(){
        ListNode n4=new ListNode(3);
        ListNode n3=new ListNode(2,n4);
        ListNode n2=new ListNode(1,n3);
        ListNode n1=new ListNode(0,n2);
        int[]nums=new int[]{0,1,3};
        System.out.println(numComponents(n1,nums));
    }

}

