package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 把二叉搜索树转换为累加树 {
    List<Integer>list=new ArrayList<>();
    Map<Integer,Integer>map;
    public TreeNode convertBST(TreeNode root) {
        //中序遍历 获取最大值
        dfs(root);
        //后缀合
        map=new HashMap<>();
        int sum=0;
        System.out.println(list.toString());
        for(int i=list.size()-1;i>=0;i--){
            sum+=list.get(i);
            map.put(list.get(i),sum);
        }
        for(Map.Entry<Integer,Integer>entry: map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        return root;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root);
        list.add(root.val);
        dfs(root);
    }
    public void dfs1(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root);
        root.val=map.get(root.val);
        dfs(root);
    }
}
