package backtrace;

import org.junit.Test;

import java.util.*;

public class testyyyy {
    public int maxValue (TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int ret=0;
        List<Integer> list=new ArrayList<>();
        Map<TreeNode,TreeNode>map=new HashMap<>();
        while (!queue.isEmpty()){
            int sz=queue.size();
            int total=0;
            for(int i=0;i<sz;i++){
                TreeNode cur=queue.poll();
                total+=cur.val;
                if(cur.left!=null){
                    map.put(cur.left,cur);
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    map.put(cur.right,cur);
                    queue.add(cur.right);
                }
            }
            list.add(total);
        }
        //System.out.println(list);
        Queue<TreeNode> queue1=new LinkedList<>();
        queue1.add(root);
        int j=0;

        while (!queue1.isEmpty()){
            int sz=queue1.size();
            int total=list.get(j++);
            int max=0;
            for(int i=0;i<sz;i++){
                TreeNode cur=queue1.poll();
                if(map.containsKey(cur)){
                    max=Math.max(max,map.get(cur).val-cur.val);
                }
                if(cur.left!=null){
                    queue1.add(cur.left);
                }
                if(cur.right!=null){
                    queue1.add(cur.right);
                }
            }
            ret=Math.max(total+max,ret);
        }
        System.out.println(ret);
        return Math.max(ret,maxValue2(root));
    }
    public int maxValue2 (TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        int ret=0;
        List<Integer>list=new ArrayList<>();
        while (!queue.isEmpty()){
            int sz=queue.size();
            int total=0;
            int maxson=0;
            for(int i=0;i<sz;i++){
                TreeNode cur=queue.poll();
                total+=cur.val;
                if(cur.left!=null){
                    maxson=Math.max(maxson,cur.left.val-cur.val);
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    maxson=Math.max(maxson,cur.right.val-cur.val);
                    queue.add(cur.right);
                }
            }
            ret=Math.max(ret,Math.max(total+maxson,total));

        }
        return ret;
    }
    @Test
    public  void maindd() {
        TreeNode node=new TreeNode(3);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        node.left=node1;
        node.right=node2;
        node1.left=node3;
        System.out.println(maxValue(node));
    }
}
