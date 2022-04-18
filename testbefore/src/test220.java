import org.junit.Test;

public class test220 {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0||head==null||head.next==null)
        {
            return head;
        }
        ListNode pre=head;

        int length=0;
        while(pre!=null)
        {   length++;
            pre=pre.next;
        }
        int temp=length-k%length;//断开的地方
        //如果正好是整数倍，则应该直接返回temp
        if(temp==length)
            return head;
        pre=head;
        while(temp>0)
        {
            temp--;
            pre=pre.next;
        }
        ListNode ret=pre;
        pre.next=null;
        return ret;
    }
    boolean flag=true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p,q);
        return flag;
    }
    public void dfs(TreeNode p,TreeNode q)
    {
        if(p==null&&q==null)
            return;
        if(p==null||q==null||(p.val!=q.val))
            flag=false;
        dfs(p.left,q.left);
        dfs(p.right,q.right);
    }
@Test
    public void test()
    {   ListNode l4=new ListNode(3);
        ListNode l3=new ListNode(2,l4);
        ListNode l2=new ListNode(1,l3);
        ListNode l1=new ListNode(0,l2);
        ListNode ans=rotateRight(l1,2);
        System.out.println(ans);

    }
}
