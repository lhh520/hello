package Node;

import java.util.ArrayList;
import java.util.List;

public class test235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode>l1=getPath(root,p);
        List<TreeNode>l2=getPath(root,q);
        System.out.println(l1.size());
        int i;
        for(i=0;i<l1.size()&&i<l2.size();i++){
             if(l2.get(i)==l1.get(i)){
                 continue;
             }else
                 break;
        }
        return l1.get(i);
    }
    public List<TreeNode> getPath(TreeNode root,TreeNode target){
         List<TreeNode>temp=new ArrayList<>();
         TreeNode node=root;
         while(node!=target){
             temp.add(node);
             if(node.val>target.val){
                 node=node.left;
             }else if(node.val<target.val){
                 node=node.right;
             }
         }
         temp.add(node);
         return temp;
    }
}
