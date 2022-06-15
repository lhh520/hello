package testproject;

import org.junit.Test;

import java.util.*;

public class 具有所有最深节点的最小子树 {
    Map<Integer,TreeNode> map=new HashMap<>();
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        findParent(root);//已经记录下来父节点
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        List<TreeNode>list=new ArrayList<>();
        while (!queue.isEmpty()){
            int sz=queue.size();
            list.clear();
            for(int i=0;i<sz;i++){
                TreeNode temp=queue.poll();
                list.add(temp);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }
        //进行深度查找
        Set<TreeNode>set=new HashSet<>();
        for(int i=0;i<list.size();i++){
            set.add(list.get(i));
        }
        System.out.println(1);
        while (set.size()!=1){
            for(TreeNode s:set){
                set.remove(s);
                set.add(map.get(s.val));
                break;
            }
        }
        for(TreeNode s:set){
            return s;
        }
        return null;
    }
    public void findParent(TreeNode node){
        if(node.left!=null){
            map.put(node.left.val,node);
            findParent(node.left);
        }
        if(node.right!=null){
            map.put(node.right.val,node);
            findParent(node.right);
        }
    }
    @Test
    public void test(){
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(0);
        TreeNode g = new TreeNode(8);
        TreeNode h = new TreeNode(7);
        TreeNode i = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = h;
        e.right =i;
        c.left=f;
        c.right=g;
        System.out.println(subtreeWithAllDeepest(a).val);
    }

}
