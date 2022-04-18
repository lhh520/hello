package face;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class face0403 {
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode>list=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty())
        {
            int sz=queue.size();
            ListNode newhe=new ListNode(0);
            ListNode cur=newhe;
            for (int i = 0; i <sz; i++)
            {
                TreeNode temp=queue.poll();
                ListNode tt=new ListNode(temp.val);
                cur.next=tt;
                cur=tt;
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            list.add(newhe);
        }
        ListNode[] ans=new ListNode[list.size()];
        for (int i = 0; i <list.size(); i++) {
            ans[i]=list.get(i);
        }
        return ans;
    }
}
