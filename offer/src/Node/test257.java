package Node;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test257 {
    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        System.out.println(lists.size());
        List<String>ans=new ArrayList<>();
        for(List<Integer>item:lists){
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<item.size();i++){
                sb.append(item.get(i));
                if(i>=0&&i<item.size()-1){
                    sb.append("->");
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }
    public void dfs(TreeNode root){
        if(root==null)
            return;
        list.add(root.val);
        if(root.left==null&&root.right==null){
            lists.add(new ArrayList<>(list));
        }
        dfs(root.left);
        dfs(root.right);
        list.remove(list.size()-1);
    }
    @Test
    public void test(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        a.left = b;
        a.right = c;
        b.right = d;
        c.left = e;
        c.right = f;
        f.left = g;
        List<String>li=binaryTreePaths(a);
        System.out.println(li.toString());
    }
}
