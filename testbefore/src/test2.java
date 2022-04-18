import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class test2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum1=0;
    while (l1!=null)
    {
        sum1=sum1*10+l1.val;
        l1=l1.next;
    }
        //System.out.println(sum1);
    int sum2=0;
        while (l2!=null)
        {
            sum2=sum2*10+l2.val;
            l2=l2.next;
        }
        int sum=sum1+sum2;
        ListNode pre=new ListNode(0);
        Stack<Integer>stack=new Stack<>();
        while (sum!=0)
        {   int temp=sum%10;
            stack.push(temp);
            sum=sum/10;
        }
        //System.out.println(stack);
        ListNode newhead=null;
        int len=stack.size();
        for(int i=0;i<len;i++)
        {
            ListNode node=new ListNode(stack.pop());
            //System.out.println(node.val);
            if(newhead==null)
                newhead=node;
            else
            {
                node.next=newhead;
                newhead=node;
            }
        }
        return newhead;
    }
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2)
    {
        ListNode pre=new ListNode(0);
        ListNode cur=pre;
        int carry=0;
        while (l1!=null||l2!=null)
        {
            int x=l1==null?0:l1.val;
            int y=l2==null?0:l2.val;
            int sum=x+y+carry;
            carry=sum/10;
            sum=sum%10;
            cur.next=new ListNode(sum);
            cur=cur.next;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }
        if(carry==1)
            cur.next=new ListNode(carry);
        return pre.next;
    }
    @Test
    public void test()
    {
        ListNode n4=new ListNode(3);
        ListNode n3=new ListNode(2,n4);
        ListNode n2=new ListNode(1);
        ListNode n1=new ListNode(0);
        ListNode l2=addTwoNumbers(n1,n2);
        int sum2=0;
        while (l2!=null)
        {
            sum2=sum2*10+l2.val;
            l2=l2.next;
        }
        System.out.println(sum2);
    }
}
