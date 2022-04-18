package offertest1;

import java.util.*;

public class offer32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>lists=new ArrayList<>();
        if(root==null)
            return lists;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        int j=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer>list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp=queue.poll();
                list.add(temp.val);
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            if(j%2==0)
                lists.add(new ArrayList<>(list));
            else{
                Collections.reverse(list);
                lists.add(new ArrayList<>(list));}
            j++;
        }
        return lists;
    }
}
