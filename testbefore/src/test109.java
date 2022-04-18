import java.util.List;

public class test109 {
    public TreeNode sortedListToBST(ListNode head) {
       return dfs(head,null);
    }
    public TreeNode dfs(ListNode left,ListNode right)
    {
        if(left==right)
            return null;
        ListNode mid=findmid(left,right);
        TreeNode root=new TreeNode(mid.val);
        root.left=dfs(left,mid);
        root.right=dfs(mid.next,right);
        return root;
    }
    public ListNode findmid(ListNode left,ListNode right)
    {
        ListNode fast=left;
        ListNode slow=left;
        while(fast!=right&&fast.next!=right)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
