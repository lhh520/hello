package face;

import org.junit.Test;

import java.util.*;

public class face07 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode>set=new HashSet<>();
        ListNode aa=headA;
        ListNode bb=headB;
        while (aa!=null)
        {
            set.add(aa);
            aa=aa.next;
        }
        while (bb!=null)
        {
            if(set.contains(bb))
                return bb;
            aa=aa.next;
        }
        return null;
    }
    //face 02 06
    public boolean isPalindrome(ListNode head) {
    List<Integer>list=new ArrayList<>();
    while (head!=null)
    {
        list.add(head.val);
        head=head.next;
    }
    List<Integer>list1=new ArrayList<>(list);
        Collections.reverse(list);
        System.out.println(list);
        System.out.println(list1);
        return list.equals(list1);

    }
    //face0201
    public ListNode removeDuplicateNodes(ListNode head) {
    Set<Integer>set=new HashSet<>();
    ListNode pr=head;
    set.add(head.val);
    while (pr.next!=null)
    {    ListNode temp=pr.next;
        if(!set.contains(temp.val))
        {
            set.add(temp.val);
            pr=pr.next;

        }
       else
           pr.next=pr.next.next;

    }
    pr.next=null;
    return head;
    }
    //2000
    /*public String reversePrefix(String word, char ch) {
        List<Character>
    }*/
    //
    //657
    public boolean judgeCircle(String moves) {
    int[]nums=new int[2];
    for(int i=0;i<moves.length();i++)
    {
        if(moves.charAt(i)=='L')
            nums[0]++;
        if(moves.charAt(i)=='R')
            nums[0]--;
        if(moves.charAt(i)=='U')
            nums[1]++;
        if(moves.charAt(i)=='D')
            nums[1]--;
    }
    return nums[0]==0&&nums[1]==0?true:false;
    }
    //674
    public int findLengthOfLCIS(int[] nums) {
        int n=nums.length;
        int start=0;
        int len=0;
        for(int i=0;i<n;i++)
        {
            if(i>0&&nums[i]<=nums[i-1])
                start=i;
            len=Math.max(len,i-start+1);
        }
    return len;
    }
    public int findLengthOfLCIS1(int[] nums)
    {
        int n=nums.length;
        int count=1;
        int ans=1;
        for(int i=1;i<n;i++)
        {
            if(nums[i]>nums[i-1])
                count++;
            //重新计数
            else
                count=1;
            ans=Math.max(ans,count);
        }
        return ans;
    }
    @Test
    public void test()
    {

    }
}
